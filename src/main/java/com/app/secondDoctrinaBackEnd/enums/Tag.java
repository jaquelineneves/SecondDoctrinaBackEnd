package com.app.secondDoctrinaBackEnd.enums;

public enum Tag {
    NAO_FEITO(1, "Não Feito"),
    FEITO(2, "Feito");

    private Integer cod;
    private String descricao;

    private Tag(int cod, String descricao){
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
    public static Tag ToEnum(Integer cod){
        if (cod == null ){
            return null;
        }

        //se o codigo for 1 retorna não feito, se for 2 retorna feito
        for(Tag x : Tag.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido " + cod);
    }
}
