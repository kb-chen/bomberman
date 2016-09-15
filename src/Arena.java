import java.awt.*;

public class Arena {

    private int size;
    private Piece[][] mat;

    public Arena(int s) {
        size = s;
        mat = new Piece[size][size];
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (r == 0 || r == size - 1 || c == 0 || c == size - 1)
                    mat[r][c] = new Piece("hardBlock");
                else if (r % 2 == 0 && c % 2 == 0)
                    mat[r][c] = new Piece("hardBlock");
                else if ((r == 1 || r == 2 || r == size - 2 || r == size - 3) && (c == 1 || c == 2 || c == size - 2 || c == size - 3))
                    mat[r][c] = new Piece("blank");
                else if ((int) (Math.random() * 4) != 0)
                    mat[r][c] = new Piece("softBlock");
                else
                    mat[r][c] = new Piece("blank");
            }
        }
    }

    public Piece getPiece(int r, int c) {
        return mat[r][c];
    }

    public void drawArena(Graphics g) {
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                mat[r][c].drawPiece(g, c * 48, r * 48);
            }
        }
    }

    public void dropBomb(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();

        mat[r][c].setID("bomb");
    }

    public void bomb2(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();

        mat[r][c].setID("bomb2");
    }

    public void bomb3(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();

        mat[r][c].setID("bomb3");
    }

    public void setTangible(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();

        mat[r][c].setTangible();
    }

    public void explode(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();
        int l = bomb.getLength();

        mat[r][c].setID("fireCenter2");
        int a = 1;
        boolean ended = false;
        while (a <= l && !ended) {
            if (mat[r + a][c].getID().contains("Up")) {
                mat[r + a][c].setID("fireDEnd2");
                ended = true;
            } else if (mat[r + a][c].getID().equals("softBlock")) {
                int num = (int) (Math.random() * 5);
                if (num == 0) mat[r + a][c].setID("speedUp");
                else if (num == 1) mat[r + a][c].setID("powerUp");
                else if (num == 2) mat[r + a][c].setID("bombsUp");
                else mat[r + a][c].setID("fireDEnd2");
                ended = true;
            } else if (mat[r + a][c].getID().equals("hardBlock")) {
                mat[r + a - 1][c].setID("fireDEnd2");
                ended = true;
            } else if (mat[r + a][c].getID().equals("bomb") || mat[r + a][c].getID().contains("fire")) {
                mat[r + a - 1][c].setID("fireVertical2");
                ended = true;
            } else if (mat[r + a][c].getID().equals("blank")) {
                if (a == l){
                    mat[r + a][c].setID("fireDEnd2");
                    ended = true;
                }
                else {
                    mat[r + a][c].setID("fireVertical2");
                    a++;
                }
            } else ended = true;
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (mat[r - a][c].getID().contains("Up")) {
                mat[r - a][c].setID("fireUEnd2");
                ended = true;
            } else if (mat[r - a][c].getID().equals("softBlock")) {
                int num = (int) (Math.random() * 5);
                if (num == 0) mat[r - a][c].setID("speedUp");
                else if (num == 1) mat[r - a][c].setID("powerUp");
                else if (num == 2) mat[r - a][c].setID("bombsUp");
                else mat[r - a][c].setID("fireUEnd2");
                ended = true;
            } else if (mat[r - a][c].getID().equals("hardBlock")) {
                mat[r - a + 1][c].setID("fireUEnd2");
                ended = true;
            } else if (mat[r - a][c].getID().equals("bomb") || mat[r - a][c].getID().contains("fire")) {
                mat[r - a + 1][c].setID("fireVertical2");
                ended = true;
            } else if (mat[r - a][c].getID().equals("blank")) {
                if (a == l){
                    mat[r - a][c].setID("fireUEnd2");
                    ended = true;
                }
                else {
                    mat[r - a][c].setID("fireVertical2");
                    a++;
                }
            } else ended = true;
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (mat[r][c + a].getID().contains("Up")) {
                mat[r][c + a].setID("fireREnd2");
                ended = true;
            } else if (mat[r][c + a].getID().equals("softBlock")) {
                int num = (int) (Math.random() * 6);
                if (num == 0) mat[r][c + a].setID("speedUp");
                else if (num == 1) mat[r][c + a].setID("powerUp");
                else if (num == 2) mat[r][c + a].setID("bombsUp");
                else mat[r][c + a].setID("fireREnd2");
                ended = true;
            } else if (mat[r][c + a].getID().equals("hardBlock")) {
                mat[r][c + a - 1].setID("fireREnd2");
                ended = true;
            } else if (mat[r][c + a].getID().equals("bomb") || mat[r][c + a].getID().contains("fire")) {
                mat[r][c + a - 1].setID("fireHorizontal2");
                ended = true;
            } else if (mat[r][c + a].getID().equals("blank")) {
                if (a == l){
                    mat[r][c + a].setID("fireREnd2");
                    ended = true;
                }
                else {
                    mat[r][c + a].setID("fireHorizontal2");
                    a++;
                }
            } else ended = true;
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (mat[r][c - a].getID().contains("Up")) {
                mat[r][c - a].setID("fireLEnd2");
                ended = true;
            } else if (mat[r][c - a].getID().equals("softBlock")) {
                int num = (int) (Math.random() * 6);
                if (num == 0) mat[r][c - a].setID("speedUp");
                else if (num == 1) mat[r][c - a].setID("powerUp");
                else if (num == 2) mat[r][c - a].setID("bombsUp");
                else mat[r][c - a].setID("fireLEnd2");
                ended = true;
            } else if (mat[r][c - a].getID().equals("hardBlock")) {
                mat[r][c - a + 1].setID("fireLEnd2");
                ended = true;
            } else if (mat[r][c - a].getID().equals("bomb") || mat[r][c - a].getID().contains("fire")) {
                mat[r][c - a + 1].setID("fireHorizontal2");
                ended = true;
            } else if (mat[r][c - a].getID().equals("blank")) {
                if (a == l) {
                    mat[r][c - a].setID("fireLEnd2");
                    ended = true;
                }
                else {
                    mat[r][c - a].setID("fireHorizontal2");
                    a++;
                }
            } else ended = true;

        }

        mat[r][c].setID("fireCenter2");
    }

    public void expand(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();
        int l = bomb.getLength();

        mat[r][c].setID("fireCenter");
        int a = 1;
        boolean ended = false;
        while (a <= l && !ended) {
            if (!(mat[r + a][c].getID().contains("fire")))
                ended = true;
            else{
                if(mat[r + a][c].getID().equals("fireDEnd2")){
                    mat[r + a][c].setID("fireDEnd");
                    ended=true;
                } else {
                    mat[r + a][c].setID("fireVertical");
                    a++;
                }
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r - a][c].getID().contains("fire")))
                ended = true;
            else{
                if(mat[r - a][c].getID().equals("fireUEnd2")){
                    mat[r - a][c].setID("fireUEnd");
                    ended=true;
                } else {
                    mat[r - a][c].setID("fireVertical");
                    a++;
                }
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r][c + a].getID().contains("fire")))
                ended = true;
            else{
                if(mat[r][c + a].getID().equals("fireREnd2")){
                    mat[r][c + a].setID("fireREnd");
                    ended=true;
                } else {
                    mat[r][c + a].setID("fireHorizontal");
                    a++;
                }
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r][c - a].getID().contains("fire")))
                ended = true;
            else {
                if (mat[r][c - a].getID().equals("fireLEnd2")) {
                    mat[r][c - a].setID("fireLEnd");
                    ended = true;
                } else {
                    mat[r][c - a].setID("fireHorizontal");
                    a++;
                }
            }
        }
    }

    public void unexpand(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();
        int l = bomb.getLength();

        mat[r][c].setID("fireCenter2");
        int a = 1;
        boolean ended = false;
        while (a <= l && !ended) {
            if (!(mat[r + a][c].getID().contains("fire")))
                ended = true;
            else{
                if(mat[r + a][c].getID().equals("fireDEnd")){
                    mat[r + a][c].setID("fireDEnd2");
                    ended=true;
                } else {
                    mat[r + a][c].setID("fireVertical2");
                    a++;
                }
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r - a][c].getID().contains("fire")))
                ended = true;
            else{
                if(mat[r - a][c].getID().equals("fireUEnd")){
                    mat[r - a][c].setID("fireUEnd2");
                    ended=true;
                } else {
                    mat[r - a][c].setID("fireVertical2");
                    a++;
                }
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r][c + a].getID().contains("fire")))
                ended = true;
            else{
                if(mat[r][c + a].getID().equals("fireREnd")){
                    mat[r][c + a].setID("fireREnd2");
                    ended=true;
                } else {
                    mat[r][c + a].setID("fireHorizontal2");
                    a++;
                }
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r][c - a].getID().contains("fire")))
                ended = true;
            else {
                if (mat[r][c - a].getID().equals("fireLEnd")) {
                    mat[r][c - a].setID("fireLEnd2");
                    ended = true;
                } else {
                    mat[r][c - a].setID("fireHorizontal2");
                    a++;
                }
            }
        }
    }

    public void clearFire(Bomb bomb) {
        int r = bomb.getRow();
        int c = bomb.getCol();
        int l = bomb.getLength();

        mat[r][c].setID("blank");
        int a = 1;
        boolean ended = false;
        while (a <= l && !ended) {
            if (!(mat[r + a][c].getID().contains("fire") || mat[r + a][c].getID().equals("blank")))
                ended = true;
            else{
                mat[r + a][c].setID("blank");
                a++;
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r - a][c].getID().contains("fire")||mat[r - a][c].getID().equals("blank")))
                ended = true;
            else{
                mat[r - a][c].setID("blank");
                a++;
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r][c + a].getID().contains("fire")||mat[r][c + a].getID().equals("blank")))
                ended = true;
            else{
                mat[r][c + a].setID("blank");
                a++;
            }
        }

        a = 1;
        ended = false;
        while (a <= l && !ended) {
            if (!(mat[r][c - a].getID().contains("fire")||mat[r][c - a].getID().equals("blank")))
                ended = true;
            else{
                mat[r][c - a].setID("blank");
                a++;
            }
        }
    }
}
