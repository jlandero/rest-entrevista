����   4 W  .com/example/accessingdatamongodb/data/Usuarios  java/lang/Object id Ljava/lang/String; RuntimeVisibleAnnotations (Lorg/springframework/data/annotation/Id; item qty I size ,Lcom/example/accessingdatamongodb/data/Size; status getId ()Ljava/lang/String; Code	     LineNumberTable LocalVariableTable this 0Lcom/example/accessingdatamongodb/data/Usuarios; setId (Ljava/lang/String;)V MethodParameters getItem	   	  setItem getQty ()I	  " 
  setQty (I)V getSize .()Lcom/example/accessingdatamongodb/data/Size;	  (   setSize /(Lcom/example/accessingdatamongodb/data/Size;)V 	getStatus	  -   	setStatus <init> f(Ljava/lang/String;Ljava/lang/String;ILcom/example/accessingdatamongodb/data/Size;Ljava/lang/String;)V
  2 / 3 ()V toString 6 java/lang/StringBuilder
 5 2 9 Usuarios [id=
 5 ; < = append -(Ljava/lang/String;)Ljava/lang/StringBuilder; ? , item= A , qty=
 5 C < D (I)Ljava/lang/StringBuilder; F , size=
 5 H < I -(Ljava/lang/Object;)Ljava/lang/StringBuilder; K 	, status= M ]
 5 O 4  builder Ljava/lang/StringBuilder; 
SourceFile Usuarios.java 8Lorg/springframework/data/mongodb/core/mapping/Document; 
collection usuarios !                   	     
                      /     *� �                               >     *+� �       
                                       /     *� �                               >     *+� �       
                      	       	           /     *� !�                         # $     >     *� !�       
       !                
       
    % &     /     *� '�           #              ) *     >     *+� '�       
    &  '                           +      /     *� ,�           )              .      >     *+� ,�       
    ,  -                           / 0     �      *� 1*+� *,� *� !*� '*� ,�           /  0 	 1  2  3  4  5    >                     	       
                        	   
          4      �     P� 5Y� 7L+8� :*� � :>� :*� � :@� :*� !� BE� :*� '� GJ� :*� ,� :L� :W+� N�           8  9 - : K ;        P      H P Q   / 3     3     *� 1�       
    =  >              R    S      T  Us V                                              /DataSourceDefinitions///javax.annotation.sql/AA☁���� BAnnotation/java.lang.annotation/ManagedBean///javax.annotation/AA☁����    +RolesAllowed/#/☁ /javax.annotation.security���� &DenyAll/#/☁ /javax.annotation.security���� /DataSourceDefinitions/#/☁ /javax.annotation.sql���� .DataSourceDefinition/#/☁ /javax.annotation.sql���� AuthenticationType/1/䀙⠀���� !ManagedBean/#/☁ /javax.annotation���� +DeclareRoles/#/☁ /javax.annotation.security���� $RunAs/#/☁ /javax.annotation.security����  PreDestroy/#/☁ /javax.annotation���� Resources/#/☁ /javax.annotation���� Priority/#/☁ /javax.annotation���� #PostConstruct/#/☁ /javax.annotation���� Resource/#/☁䀀/javax.annotation���� Generated/#/☁ /javax.annotation���� (PermitAll/#/☁ /javax.annotation.security����   % Gvalue/0//Resources/☁ /javax.annotation///Ё /javax.annotation.Resource[]���� :name/0//Resource/☁䀀/javax.annotation///Ё/java.lang.String���� Juser/0//DataSourceDefinition/☁ /javax.annotation.sql///Ё/java.lang.String���� .value/0//Priority/☁ /javax.annotation///Ё /int���� DmaxPoolSize/0//DataSourceDefinition/☁ /javax.annotation.sql///Ё/int���� PserverName/0//DataSourceDefinition/☁ /javax.annotation.sql///Ё/java.lang.String���� 9type/0//Resource/☁䀀/javax.annotation///Ё/java.lang.Class���� DminPoolSize/0//DataSourceDefinition/☁ /javax.annotation.sql///Ё/int���� >value/0//ManagedBean/☁ /javax.annotation///Ё/java.lang.String���� RdatabaseName/0//DataSourceDefinition/☁ /javax.annotation.sql///�<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.7.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>accessing-data-mongodb</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>accessing-data-mongodb</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupI