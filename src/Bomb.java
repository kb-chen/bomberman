public class Bomb {

    private int row, col, length, startTime;

    public Bomb(int r, int c, int l, int start)
    {
        row=r;
        col=c;
        length=l;
        startTime=start;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getLength() { return length; }

    public int getStart() { return startTime; }
    public void setStart(int time) { startTime=time; }

    public int getStartExplosion() { return startTime + 40; }

    public boolean inRange(Bomb bomb)
    {
        int r = bomb.getRow();
        int c = bomb.getCol();
        int l = bomb.getLength();
        if(r+l>=row && c==col || r-l<=row && c==col || r==row && c+l>=col || r==row && c-l<=col)
            return true;
        return false;
    }
}
