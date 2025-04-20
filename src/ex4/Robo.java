package ex4;

public class Robo {

    private String statusAtual;
    private int id = ((int) (Math.random() * 1000) + 1000), posX, posY;
    private double qtdPo, limPo;

    private enum Status {
        DESLIGADO, LIGADO, ANDANDO, PARADO;
    }

    public Robo() {
        this.posX = 0;
        this.posY = 0;
        this.qtdPo = 0;
        this.limPo = 1000;
        this.statusAtual = String.valueOf(Status.DESLIGADO);
    }

    public String getStatusAtual() {
        return statusAtual;
    }

    public double getLimPo() {
        return limPo;
    }

    public boolean desligar() {
        this.statusAtual = String.valueOf((Status.DESLIGADO));
        return true;
    }

    public boolean ligar() {
        this.statusAtual = String.valueOf(Status.LIGADO);
        return true;
    }

    public boolean andar(int posX, int posY) {
        this.statusAtual = String.valueOf(Status.ANDANDO);
        this.posX += posX;
        this.posY += posY;
        return true;
    }

    public boolean aspirar(double qtdPo) {

        if (this.qtdPo + qtdPo > limPo) {
            System.out.println("Limite de pó atingido!" +
                    "\nEsvazie o recipiente para pó!");

            desligar();
            this.qtdPo = limPo;

            return false;

        } else {
            this.qtdPo += qtdPo;
        }
        return true;
    }

    public boolean parar() {
        this.statusAtual = String.valueOf(Status.PARADO);
        return true;
    }

    @Override
    public String toString() {
        return "\nID: " + id +
                "\nPosicao X: " + posX +
                "\nPosicao Y: " + posY +
                "\nQuantidade de Pó armazenado: " + qtdPo +
                "\nCapacidade de máxima: " + limPo +
                "\nStatus: " + statusAtual + "\n";
    }
}
