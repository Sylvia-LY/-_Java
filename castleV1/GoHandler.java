public class GoHandler implements Handler {
    @Override
    public boolean doCmd(String word, Game game) {
        game.proceedToNextRoom(word);
        return false;
    }
}
