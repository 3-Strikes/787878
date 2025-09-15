package _03_注解解析;

public enum Sex {
    Man("公的") {
        @Override
        public void ab() {
            System.out.println(name()+"重写后的方法");
        }
    },Women("女的") {
        @Override
        public void ab() {
            System.out.println(name()+"重写后的方法");
        }
    },Other("其它的") {
        @Override
        public void ab() {
            System.out.println(name()+"重写后的方法");
        }
    };
    private String name;

    Sex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "name='" + name + '\'' +
                '}';
    }

    public abstract void ab();

}
