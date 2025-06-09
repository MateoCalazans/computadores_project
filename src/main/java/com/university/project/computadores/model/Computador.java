package com.university.project.computadores.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.URL;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Representa a entidade Computador no banco de dados.
 * Esta classe contém os atributos de um computador e as validações
 * necessárias para garantir a integridade dos dados.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computador {

    /**
     * Identificador único do computador.
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nome do modelo do computador.
     * Não pode estar em branco e deve ter no máximo 100 caracteres.
     */
    @NotBlank(message = "O nome do computador não pode estar em branco.")
    @Size(max = 100, message = "O nome não pode ter mais que 100 caracteres")
    @Column(nullable = false, length = 100)
    private String nome;

    /**
     * Marca do fabricante do computador.
     * Não pode estar em branco e deve ter no máximo 50 caracteres.
     */
    @NotBlank(message = "A marca do computador não pode estar em branco.")
    @Size(max = 50, message = "A marca não pode ter mais que 50 caracteres")
    @Column(nullable = false, length = 50)
    private String marca;

    /**
     * Modelo do processador do computador.
     * Não pode estar em branco e deve ter no máximo 100 caracteres.
     */
    @NotBlank(message = "O processador não pode estar em branco.")
    @Size(max = 100, message = "O processador não pode ter mais que 100 caracteres")
    @Column(nullable = false, length = 100)
    private String processador;

    /**
     * Capacidade e tipo da memória RAM.
     * Não pode estar em branco e deve ter no máximo 50 caracteres.
     */
    @NotBlank(message = "A memória RAM não pode estar em branco.")
    @Size(max = 50, message = "A memória RAM não pode ter mais que 50 caracteres")
    @Column(nullable = false, length = 50)
    private String memoriaRam;

    /**
     * Capacidade e tipo do armazenamento.
     * Não pode estar em branco e deve ter no máximo 100 caracteres.
     */
    @NotBlank(message = "O armazenamento não pode estar em branco.")
    @Size(max = 100, message = "O armazenamento não pode ter mais que 100 caracteres")
    @Column(nullable = false, length = 100)
    private String armazenamento;

    /**
     * Preço do computador.
     * Deve ser um valor positivo e não nulo.
     */
    @NotNull(message = "O preço não pode ser nulo.")
    @Positive(message = "O preço deve ser um valor positivo.")
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal preco;

    /**
     * Descrição detalhada do computador.
     * Campo opcional com tamanho máximo de 1000 caracteres.
     */
    @Size(max = 1000, message = "A descrição não pode ter mais que 1000 caracteres")
    @Column(nullable = true, length = 1000)
    private String descricao;

    /**
     * URL da imagem do computador.
     * Deve ser uma URL válida apontando para uma imagem na pasta static.
     * Exemplo: /images/computadores/notebook1.jpg
     */
    @NotBlank(message = "A URL da imagem não pode estar em branco.")
    @Column(nullable = false)
    private String imageUrl;

    /**
     * Data e hora em que o computador foi marcado como deletado.
     * Null indica que o computador está ativo.
     * Usado para implementar soft delete.
     */
    @Column(nullable = true)
    private LocalDateTime isDeleted = null;

    // equals e hashCode (gerados pela IDE ou manualmente, baseados no ID)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computador that = (Computador) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // toString (opcional, mas útil para debug)
    @Override
    public String toString() {
        return "Computador{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                // ... (adicionar outros campos se desejar)
                '}';
    }
}