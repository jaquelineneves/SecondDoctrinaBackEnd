package com.app.secondDoctrinaBackEnd.enums;

public enum FormaAprendizagem {
    LEITURA(1, "Leitura"),
    VIDEO(2, "Vídeo");

    private Integer cod;
    private String descricao;

    private FormaAprendizagem(int cod, String descricao){
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod(){
        return cod;
    }

    public String getDescricao(){
        return descricao;
    }

    // roda msm sem ter um objeto instanciado, por ser estatico
    public static FormaAprendizagem ToEnum(Integer cod){
        if (cod == null ){
            return null;
        }

        //se o codigo for 1 retorna leitura, se for 2 video
        for(FormaAprendizagem x : FormaAprendizagem.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido " + cod);
    }
}