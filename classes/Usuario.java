package classes;

public abstract class Usuario {
    String nome; // 1
    String email; // 2
    String genero; // 3
    String cpf;
    int idade; // 4
    String cidade; // 5
    String estado_uf; // 6
    String telefone; // 7
    String tipo_usuario;
    
    public Usuario(String nome, String email, int idade, String genero, String cpf,
                   String cidade, String estado_uf, String telefone, String tipo_usuario) {
                    
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.idade = idade;
        this.genero = genero;
        this.cidade = cidade;
        this.estado_uf = estado_uf;
        this.telefone = telefone;
        this.tipo_usuario = tipo_usuario;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado_uf() {
        return estado_uf;
    }

    public void setEstado_uf(String estado_uf) {
        this.estado_uf = estado_uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    // metodos abstratos
    public void ver_saldo(){};
    public void ver_credito(){};

}
