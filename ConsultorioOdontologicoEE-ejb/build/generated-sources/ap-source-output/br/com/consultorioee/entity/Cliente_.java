package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Anamnese;
import br.com.consultorioee.entity.Orcamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile SingularAttribute<Cliente, String> cliendereco;
    public static volatile SingularAttribute<Cliente, String> climae;
    public static volatile SingularAttribute<Cliente, Date> clidatanascimento;
    public static volatile ListAttribute<Cliente, Orcamento> orcamentoList;
    public static volatile SingularAttribute<Cliente, String> clitrabalhonome;
    public static volatile SingularAttribute<Cliente, String> clicomple;
    public static volatile SingularAttribute<Cliente, String> clipai;
    public static volatile SingularAttribute<Cliente, String> clitelefone;
    public static volatile SingularAttribute<Cliente, String> cliestado;
    public static volatile SingularAttribute<Cliente, String> clicidade;
    public static volatile SingularAttribute<Cliente, String> clitrabalhoendereco;
    public static volatile ListAttribute<Cliente, Anamnese> anamneseList;
    public static volatile SingularAttribute<Cliente, String> cliobs;
    public static volatile SingularAttribute<Cliente, String> clitrabalho;
    public static volatile SingularAttribute<Cliente, String> clinome;
    public static volatile SingularAttribute<Cliente, String> cliocupacao;
    public static volatile SingularAttribute<Cliente, String> clitrabalhoobs;
    public static volatile SingularAttribute<Cliente, String> clientecol;
    public static volatile SingularAttribute<Cliente, Integer> cliid;
    public static volatile SingularAttribute<Cliente, String> clicelular;
    public static volatile SingularAttribute<Cliente, Integer> cliidade;

}