PGDMP                         y            adsi56    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    32975    adsi56    DATABASE     e   CREATE DATABASE adsi56 WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Colombia.1252';
    DROP DATABASE adsi56;
                postgres    false            �            1259    32976    personas    TABLE     �   CREATE TABLE public.personas (
    "Codigo" character varying(6) NOT NULL,
    "Nombres" character varying(50) NOT NULL,
    "Genero" character varying(20) NOT NULL
);
    DROP TABLE public.personas;
       public         heap    postgres    false            �          0    32976    personas 
   TABLE DATA           A   COPY public.personas ("Codigo", "Nombres", "Genero") FROM stdin;
    public          postgres    false    200   q       !           2606    32982    personas personas_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.personas
    ADD CONSTRAINT personas_pkey PRIMARY KEY ("Codigo");
 @   ALTER TABLE ONLY public.personas DROP CONSTRAINT personas_pkey;
       public            postgres    false    200            �   _   x�34�tKL�L���M,N.�����242��M�I���L�tK�M��s:��#�4��O)�L�WpO,J�LD�� �OT�M,*,M�B����� �y%�     