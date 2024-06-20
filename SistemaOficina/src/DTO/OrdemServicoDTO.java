package DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdemServicoDTO {
    private int id;
    private ClienteDTO cliente;
    private PecaDTO peca;
    private String status;
    private double valorServico; // Novo campo para valor do serviço
    private double valorPecas; // Novo campo para valor das peças
    private String descricao;
    private int quantidade;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cliente
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the valorServico
     */
    public double getValorServico() {
        return valorServico;
    }

    /**
     * @param valorServico the valorServico to set
     */
    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    /**
     * @return the valorPeca
     */
    public double getValorPecas() {
        return valorPecas;
    }

    /**
     * @param valorPecas the valorPeca to set
     */
    public void setValorPecas(double valorPecas) {
        this.valorPecas = valorPecas;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the peca
     */
    public PecaDTO getPeca() {
        return peca;
    }

    /**
     * @param peca the peca to set
     */
    public void setPeca(PecaDTO peca) {
        this.peca = peca;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
