package br.com.fiap.carrosapi.model;

public record Carro(
	int id,
	String nome,
	String marca,
	Double nota
) {}
