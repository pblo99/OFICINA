package DTO;

public class ItemPedidoDTO {
    private String codigoPeca;
    private int quantidade;

    public ItemPedidoDTO(String codigoPeca, int quantidade) {
        this.codigoPeca = codigoPeca;
        this.quantidade = quantidade;
    }

    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
