package com.github.ProjetoGoodHands.GoodHands.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tema")
public class TemaPostagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Campo Obrigatório")
	@Size(max = 255)
	private String causa;

	@NotNull(message = "Campo Obrigatório")
	private Double metaArrecadacao;

	public List<Postagem> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "temapostagem", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("temapostagem")
	private List<Postagem> postagem;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCausa() {
		return causa;
	}

	public void setCausa(String causa) {
		this.causa = causa;
	}

	public Double getMetaArrecadacao() {
		return metaArrecadacao;
	}

	public void setMetaArrecadacao(Double metaArrecadacao) {
		this.metaArrecadacao = metaArrecadacao;
	}

}
