package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Anamnese;
import br.com.consultorioee.entity.Cliente;
import br.com.consultorioee.entity.Orcamentoitem;
import br.com.consultorioee.entity.Parcela;
import br.com.consultorioee.entity.TipoPagamento;
import br.com.consultorioee.entity.Usuario;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Orcamento.class)
public class Orcamento_ { 

    public static volatile ListAttribute<Orcamento, Orcamentoitem> orcamentoitemList;
    public static volatile ListAttribute<Orcamento, Anamnese> anamneseList;
    public static volatile SingularAttribute<Orcamento, Date> orcdata;
    public static volatile SingularAttribute<Orcamento, Date> orchora;
    public static volatile SingularAttribute<Orcamento, Usuario> orcdentista;
    public static volatile ListAttribute<Orcamento, Parcela> parcelasList;
    public static volatile SingularAttribute<Orcamento, TipoPagamento> orcpagamento;
    public static volatile SingularAttribute<Orcamento, Integer> orcid;
    public static volatile SingularAttribute<Orcamento, Integer> orctimes;
    public static volatile SingularAttribute<Orcamento, BigDecimal> orctotal;
    public static volatile SingularAttribute<Orcamento, Cliente> orccliente;
    public static volatile SingularAttribute<Orcamento, String> orcobs;

}