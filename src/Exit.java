public class Exit implements Command {
    @Override
    public String Execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return true;
    }
}
