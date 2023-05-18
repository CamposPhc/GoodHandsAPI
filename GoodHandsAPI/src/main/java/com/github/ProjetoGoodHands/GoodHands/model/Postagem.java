package com.github.ProjetoGoodHands.GoodHands.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Campo Obrigatório")
	@Size(max = 100)
	private String imagem;

	@NotBlank(message = "Campo Obrigatório")
	@Size(max = 45)
	private String titulo;

	@NotBlank(message = "Campo Obrigatório")
	@Size(max = 1000)
	private String descricao;

	@NotBlank(message = "Campo Obrigatório")
	private Double arrecadacao;

	
	
	public TemaPostagem getTemapostagem() {
		return temapostagem;
	}

	public void setTemapostagem(TemaPostagem temapostagem) {
		this.temapostagem = temapostagem;
	}

	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private TemaPostagem temapostagem;
	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getArrecadacao() {
		return arrecadacao;
	}

	public void setArrecadacao(double arrecadacao) {
		this.arrecadacao = arrecadacao;
	}

}
