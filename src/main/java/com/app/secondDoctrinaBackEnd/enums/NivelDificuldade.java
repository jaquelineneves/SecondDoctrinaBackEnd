package com.app.secondDoctrinaBackEnd.enums;

public enum NivelDificuldade {
    FACIL(1, "Fácil"),
    MEDIO(2, "Médio"),
    DIFICIL(3, "Difícil");

    private int cod;
    private String descricao;

    private NivelDificuldade(int cod, String descricao){
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
    public static NivelDificuldade ToEnum(Integer cod){
        if (cod == null ){
            return null;
        }

        //se o codigo for 1 retorna facil, se for 2 medio e se for 3 dificil
        for(NivelDificuldade x : NivelDificuldade.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id inválido " + cod);
    }
}
