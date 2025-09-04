package _斗地主练习;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

// 扑克牌类
class Poker {
    private String num; // 牌面数字或字母
    private String color; // 花色
    private int value; // 牌的大小值，用于比较

    public Poker(String num, String color, int value) {
        this.num = num;
        this.color = color;
        this.value = value;
    }

    public String getNum() {
        return num;
    }

    public String getColor() {
        return color;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return color + num;
    }
}

// 主游戏类
public class DouDiZhuGame extends JFrame {
    private List<Poker> pokerList = new ArrayList<>(); // 所有牌
    private List<Poker> player1 = new ArrayList<>(); // 玩家1的牌
    private List<Poker> player2 = new ArrayList<>(); // 玩家2的牌
    private List<Poker> player3 = new ArrayList<>(); // 玩家3的牌
    private List<Poker> diPai = new ArrayList<>(); // 底牌
    private int landlord = -1; // 地主，-1表示未确定，0,1,2分别代表三个玩家
    private int currentPlayer = 0; // 当前出牌玩家，默认从玩家0开始
    private List<Poker> lastCards = new ArrayList<>(); // 上一轮出的牌

    // 界面组件
    private JPanel mainPanel;
    private JPanel topPanel, middlePanel, bottomPanel;
    private JButton readyButton, callLandlordButton, giveUpButton, passButton, sortButton;
    private JLabel infoLabel;
    private List<JButton> player1Cards = new ArrayList<>();
    private List<JButton> player2Cards = new ArrayList<>();
    private List<JButton> player3Cards = new ArrayList<>();
    private List<Poker> selectedCards = new ArrayList<Poker>();

    public DouDiZhuGame() {
        setTitle("斗地主游戏");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
        initGame();
    }

    // 初始化界面
    private void initUI() {
        mainPanel = new JPanel(new BorderLayout());

        // 顶部面板 - 电脑玩家1
        topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(1000, 150));
        topPanel.setBorder(BorderFactory.createTitledBorder("电脑玩家1"));
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // 中间面板 - 游戏信息和操作
        middlePanel = new JPanel(new BorderLayout());
        middlePanel.setPreferredSize(new Dimension(1000, 200));

        // 游戏信息标签
        infoLabel = new JLabel("准备开始游戏，请点击准备按钮", SwingConstants.CENTER);
        middlePanel.add(infoLabel, BorderLayout.NORTH);

        // 操作按钮面板
        JPanel controlPanel = new JPanel();
        readyButton = new JButton("准备");
        callLandlordButton = new JButton("叫地主");
        giveUpButton = new JButton("不叫");
        passButton = new JButton("不出");
        sortButton = new JButton("排序");

        // 初始状态下只有准备按钮可用
        callLandlordButton.setEnabled(false);
        giveUpButton.setEnabled(false);
        passButton.setEnabled(false);
        sortButton.setEnabled(false);

        controlPanel.add(readyButton);
        controlPanel.add(callLandlordButton);
        controlPanel.add(giveUpButton);
        controlPanel.add(passButton);
        controlPanel.add(sortButton);

        middlePanel.add(controlPanel, BorderLayout.CENTER);
        mainPanel.add(middlePanel, BorderLayout.CENTER);

        // 底部面板 - 玩家自己
        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(1000, 150));
        bottomPanel.setBorder(BorderFactory.createTitledBorder("玩家"));
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // 添加按钮事件监听
        addEventListeners();

        add(mainPanel);
    }

    // 添加事件监听器
    private void addEventListeners() {
        // 准备按钮
        readyButton.addActionListener(e -> {
            readyButton.setEnabled(false);
            infoLabel.setText("正在发牌...");
            new Thread(this::dealCards).start();
        });

        // 叫地主按钮
        callLandlordButton.addActionListener(e -> {
            landlord = 0; // 玩家自己当地主
            infoLabel.setText("你成为了地主！");
            // 将底牌加入玩家手牌
            player1.addAll(diPai);
            updatePlayerCards(0);
            callLandlordButton.setEnabled(false);
            giveUpButton.setEnabled(false);
            sortButton.setEnabled(true);
            passButton.setEnabled(true);
            // 地主先出牌
            currentPlayer = 0;
            infoLabel.setText("请出牌");
        });

        // 不叫按钮
        giveUpButton.addActionListener(e -> {
            infoLabel.setText("你选择不叫地主");
            callLandlordButton.setEnabled(false);
            giveUpButton.setEnabled(false);
            // 轮到电脑决定是否叫地主
            decideComputerLandlord();
        });

        // 不出按钮
        passButton.addActionListener(e -> {
            infoLabel.setText("你选择不出");
            currentPlayer = 1; // 轮到电脑玩家1
            disableAllCardButtons();
            new Thread(this::computerPlay).start();
        });

        // 排序按钮
        sortButton.addActionListener(e -> {
            sortCards(player1);
            updatePlayerCards(0);
        });
    }

    // 初始化游戏
    private void initGame() {
        // 初始化扑克牌
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        String[] colors = {"♦", "♣", "♥", "♠"};

        for (int i = 0; i < nums.length; i++) {
            for (String color : colors) {
                pokerList.add(new Poker(nums[i], color, i + 3)); // 3的值为3，4为4，...，2为15
            }
        }

        // 添加大小王
        pokerList.add(new Poker("小王", "", 16));
        pokerList.add(new Poker("大王", "", 17));

        // 洗牌
        Collections.shuffle(pokerList);
    }

    // 发牌
    private void dealCards() {
        try {
            // 发牌给三个玩家，每人17张
            for (int i = 0; i < 17; i++) {
                player1.add(pokerList.get(i));
                player2.add(pokerList.get(i + 17));
                player3.add(pokerList.get(i + 34));
                Thread.sleep(50); // 延迟，模拟发牌过程
            }

            // 剩余3张作为底牌
            for (int i = 51; i < 54; i++) {
                diPai.add(pokerList.get(i));
            }

            // 更新界面
            SwingUtilities.invokeLater(() -> {
                sortCards(player1);
                sortCards(player2);
                sortCards(player3);

                updatePlayerCards(0);
                updatePlayerCards(1);
                updatePlayerCards(2);

                infoLabel.setText("请决定是否叫地主");
                callLandlordButton.setEnabled(true);
                giveUpButton.setEnabled(true);
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 更新玩家的牌显示
    private void updatePlayerCards(int player) {
        List<JButton> cardButtons;
        JPanel panel;
        List<Poker> cards;

        switch (player) {
            case 0:
                cardButtons = player1Cards;
                panel = bottomPanel;
                cards = player1;
                break;
            case 1:
                cardButtons = player2Cards;
                panel = topPanel;
                cards = player2;
                break;
            case 2:
                cardButtons = player3Cards;
                panel = new JPanel(); // 右侧面板，简化处理
                // 实际应用中应该有右侧面板，这里简化
                cards = player3;
                break;
            default:
                return;
        }

        // 清空面板
        panel.removeAll();
        cardButtons.clear();

        // 添加新牌
        for (Poker poker : cards) {
            JButton btn = new JButton(poker.toString());
            btn.setPreferredSize(new Dimension(60, 80));
            cardButtons.add(btn);

            // 只有玩家自己的牌可以点击选择
            if (player == 0) {
                btn.addActionListener(new CardButtonListener(btn, poker));
            }

            panel.add(btn);
        }

        panel.revalidate();
        panel.repaint();
    }

    // 牌按钮的监听器
    private class CardButtonListener implements ActionListener {
        private JButton btn;
        private Poker poker;

        public CardButtonListener(JButton btn, Poker poker) {
            this.btn = btn;
            this.poker = poker;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (selectedCards.contains(poker)) {
                // 取消选择
                selectedCards.remove(poker);
                btn.setBackground(null);
            } else {
                // 选择
                selectedCards.add(poker);
                btn.setBackground(Color.YELLOW);
            }
        }
    }

    // 排序牌
    private void sortCards(List<Poker> cards) {
        Collections.sort(cards, Comparator.comparingInt(Poker::getValue));
    }

    // 电脑决定是否叫地主
    private void decideComputerLandlord() {
        try {
            Thread.sleep(1000); // 模拟思考时间

            // 简单逻辑：50%概率叫地主
            Random random = new Random();
            if (random.nextBoolean()) {
                landlord = 1; // 电脑玩家1叫地主
                player2.addAll(diPai);
                SwingUtilities.invokeLater(() -> {
                    updatePlayerCards(1);
                    infoLabel.setText("电脑玩家1成为了地主！");
                    currentPlayer = 1;
                    sortButton.setEnabled(true);
                    passButton.setEnabled(true);
                    new Thread(this::computerPlay).start();
                });
            } else {
                Thread.sleep(1000);
                if (random.nextBoolean()) {
                    landlord = 2; // 电脑玩家2叫地主
                    player3.addAll(diPai);
                    SwingUtilities.invokeLater(() -> {
                        infoLabel.setText("电脑玩家2成为了地主！");
                        currentPlayer = 2;
                        sortButton.setEnabled(true);
                        passButton.setEnabled(true);
                        new Thread(this::computerPlay).start();
                    });
                } else {
                    // 都不叫，重新发牌
                    SwingUtilities.invokeLater(() -> {
                        infoLabel.setText("所有人都不叫地主，重新发牌...");
                        resetGame();
                        new Thread(this::dealCards).start();
                    });
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 电脑出牌
    private void computerPlay() {
        try {
            if (currentPlayer == 1) {
                infoLabel.setText("电脑玩家1正在思考...");
                Thread.sleep(2000);

                // 简单AI：如果是第一轮或可以出牌，就出最小的牌
                List<Poker> playableCards = findPlayableCards(player2);
                if (playableCards.size() > 0) {
                    // 出最小的牌
                    Collections.sort(playableCards, Comparator.comparingInt(Poker::getValue));
                    List<Poker> cardsToPlay = new ArrayList<>();
                    cardsToPlay.add(playableCards.get(0));

                    playCards(1, cardsToPlay);
                } else {
                    // 不出
                    SwingUtilities.invokeLater(() -> {
                        infoLabel.setText("电脑玩家1选择不出");
                        currentPlayer = 2;
                        new Thread(this::computerPlay).start();
                    });
                }
            } else if (currentPlayer == 2) {
                infoLabel.setText("电脑玩家2正在思考...");
                Thread.sleep(2000);

                // 简单AI逻辑同上
                List<Poker> playableCards = findPlayableCards(player3);
                if (playableCards.size() > 0) {
                    Collections.sort(playableCards, Comparator.comparingInt(Poker::getValue));
                    List<Poker> cardsToPlay = new ArrayList<>();
                    cardsToPlay.add(playableCards.get(0));

                    playCards(2, cardsToPlay);
                } else {
                    SwingUtilities.invokeLater(() -> {
                        infoLabel.setText("电脑玩家2选择不出");
                        currentPlayer = 0;
                        enableAllCardButtons();
                        infoLabel.setText("轮到你出牌");
                    });
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 查找可以出的牌
    private List<Poker> findPlayableCards(List<Poker> playerCards) {
        List<Poker> result = new ArrayList<>();

        // 如果上一轮没人出牌，所有牌都可以出
        if (lastCards.isEmpty()) {
            return new ArrayList<>(playerCards);
        }

        // 简单逻辑：只考虑单牌的情况
        if (lastCards.size() == 1) {
            int lastValue = lastCards.get(0).getValue();
            for (Poker card : playerCards) {
                if (card.getValue() > lastValue) {
                    result.add(card);
                }
            }
        }

        return result;
    }

    // 出牌
    private void playCards(int player, List<Poker> cards) {
        List<Poker> playerCards;

        switch (player) {
            case 0:
                playerCards = player1;
                break;
            case 1:
                playerCards = player2;
                break;
            case 2:
                playerCards = player3;
                break;
            default:
                return;
        }

        // 移除出的牌
        playerCards.removeAll(cards);
        lastCards = new ArrayList<>(cards);

        // 更新界面
        SwingUtilities.invokeLater(() -> {
            String playerName = player == 0 ? "你" : "电脑玩家" + player;
            infoLabel.setText(playerName + "出了：" + cards);

            updatePlayerCards(player);

            // 检查是否获胜
            if (playerCards.isEmpty()) {
                infoLabel.setText(playerName + "获胜！游戏结束！");
                disableAllButtons();
                return;
            }

            // 轮到下一个玩家
            currentPlayer = (currentPlayer + 1) % 3;

            // 如果下一个玩家是电脑，让电脑出牌
            if (currentPlayer != 0) {
                disableAllCardButtons();
                new Thread(this::computerPlay).start();
            } else {
                enableAllCardButtons();
                infoLabel.setText("轮到你出牌");
            }
        });
    }

    // 禁用所有牌按钮
    private void disableAllCardButtons() {
        for (JButton btn : player1Cards) {
            btn.setEnabled(false);
        }
    }

    // 启用所有牌按钮
    private void enableAllCardButtons() {
        for (JButton btn : player1Cards) {
            btn.setEnabled(true);
        }
    }

    // 禁用所有操作按钮
    private void disableAllButtons() {
        callLandlordButton.setEnabled(false);
        giveUpButton.setEnabled(false);
        passButton.setEnabled(false);
        sortButton.setEnabled(false);
        disableAllCardButtons();
    }

    // 重置游戏
    private void resetGame() {
        player1.clear();
        player2.clear();
        player3.clear();
        diPai.clear();
        landlord = -1;
        currentPlayer = 0;
        lastCards.clear();
        selectedCards.clear();

        updatePlayerCards(0);
        updatePlayerCards(1);
        updatePlayerCards(2);

        initGame(); // 重新初始化牌
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DouDiZhuGame().setVisible(true);
        });
    }
}

