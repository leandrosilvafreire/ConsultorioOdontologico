package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Orcamento;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Parcela.class)
public class Parcela_ { 

    public static volatile SingularAttribute<Parcela, Boolean> parpago;
    public static volatile SingularAttribute<Parcela, Integer> parid;
    public static volatile SingularAttribute<Parcela, BigDecimal> parvalor;
    public static volatile SingularAttribute<Parcela, Orcamento> parorcamento;
    public static volatile SingularAttribute<Parcela, Integer> parnumero;

}