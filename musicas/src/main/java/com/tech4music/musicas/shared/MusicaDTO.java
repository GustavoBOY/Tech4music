package com.tech4music.musicas.shared;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MusicaDTO {

    private String id;

    @NotBlank(message = "O titulo deve possuir caracteres não brancos")
    @NotEmpty(message = "O titulo deve ser preenchido")
    @Size(min = 3, message = "O titulo deve ter, no mínimo, 3 caracteres")
    private String titulo;

    private String artista;

    private String album;

    private String genero;

    @Digits(fraction = 0, integer = 4, message = "O ano deve ser preenchido corretamente, com no máximo, 4 digitos")
    private int anoLancamento;
    
    private String compositor;

    //#region Get e Set
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }
    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }
    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCompositor() {
        return compositor;
    }
    public void setCompositor(String compositor) {
        this.compositor = compositor;
    }
    //#endregion

}
