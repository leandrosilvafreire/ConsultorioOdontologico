package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Cliente;
import br.com.consultorioee.entity.Orcamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Anamnese.class)
public class Anamnese_ { 

    public static volatile SingularAttribute<Anamnese, Integer> anaid;
    public static volatile SingularAttribute<Anamnese, Orcamento> anaorcamento;
    public static volatile SingularAttribute<Anamnese, String> anadescricaodst;
    public static volatile SingularAttribute<Anamnese, Boolean> anaalergia;
    public static volatile SingularAttribute<Anamnese, String> anaobs;
    public static volatile SingularAttribute<Anamnese, Boolean> anafuma;
    public static volatile SingularAttribute<Anamnese, Integer> anadescricaooperacao;
    public static volatile SingularAttribute<Anamnese, String> anadescricaoalergia;
    public static volatile SingularAttribute<Anamnese, String> anadescricaodoenca;
    public static volatile SingularAttribute<Anamnese, Boolean> anaexercicio;
    public static volatile SingularAttribute<Anamnese, Boolean> anasdst;
    public static volatile SingularAttribute<Anamnese, Boolean> anadoenca;
    public static volatile SingularAttribute<Anamnese, Boolean> anaoperacaorecente;
    public static volatile SingularAttribute<Anamnese, String> anadescricaomedicacao;
    public static volatile SingularAttribute<Anamnese, Boolean> anamedicacao;
    public static volatile SingularAttribute<Anamnese, Cliente> anacliente;

}