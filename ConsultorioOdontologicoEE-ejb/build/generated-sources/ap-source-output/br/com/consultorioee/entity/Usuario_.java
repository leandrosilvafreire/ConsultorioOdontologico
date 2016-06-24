package br.com.consultorioee.entity;

import br.com.consultorioee.entity.Orcamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-13T00:06:32")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> usulogin;
    public static volatile SingularAttribute<Usuario, String> uspassword;
    public static volatile SingularAttribute<Usuario, Boolean> usuadministrador;
    public static volatile ListAttribute<Usuario, Orcamento> orcamentoList;
    public static volatile SingularAttribute<Usuario, String> usunome;
    public static volatile SingularAttribute<Usuario, Boolean> usudentista;
    public static volatile SingularAttribute<Usuario, Integer> usid;

}