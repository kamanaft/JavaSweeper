package sweeper;

public class Game {

    private Bomb bomb;
    private Flag flag;
    private GameState state;


    public Game (int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();
    }

    public void start () {
        bomb.start();
        flag.start();
        state = GameState.PLAYED;
    }

    public Box getBox (Coord coord) {
        if (Box.OPENED == flag.get(coord))
            return bomb.get(coord);
        else
            return flag.get(coord);
    }

    public GameState getState() {
        return state;
    }

    public void pressLeftButton (Coord coord) {
        flag.setOpenedToBox(coord);
        state = GameState.BOMBED;
    }

    public void pressRightButton (Coord coord) {
        flag.toggleFlagedToBox(coord);
        state = GameState.WINNER;
    }
}
