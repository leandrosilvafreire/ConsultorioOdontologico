package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Orcamentoitem;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Servico.class)
public class Servico_ { 

    public static volatile ListAttribute<Servico, Orcamentoitem> orcamentoitemList;
    public static volatile SingularAttribute<Servico, BigDecimal> sercusto;
    public static volatile SingularAttribute<Servico, String> sernome;
    public static volatile SingularAttribute<Servico, Integer> serid;

}