package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Orcamento;
import br.com.consultorioee.entity.Servico;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Orcamentoitem.class)
public class Orcamentoitem_ { 

    public static volatile SingularAttribute<Orcamentoitem, Orcamento> oritorcamento;
    public static volatile SingularAttribute<Orcamentoitem, Integer> oritcid;
    public static volatile SingularAttribute<Orcamentoitem, Servico> oritservico;
    public static volatile SingularAttribute<Orcamentoitem, String> oriobs;
    public static volatile SingularAttribute<Orcamentoitem, BigDecimal> oritccusto;
    public static volatile SingularAttribute<Orcamentoitem, String> orcamentoitemcol;

}