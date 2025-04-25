/*na minha cabeça herança multipla por niveis seria uma herança multipla normal, 
mas nesse caso faz muito mais sentido usar a herança multinivel, foi o que eu fiz
agora eu só nao sei se foi isso que vcs pediram ☹ */

//Superclasse pessoa
class Pessoa {
    private String cpf;
    private String dataNascimento;

    public Pessoa(String cpf, String dataNascimento) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }
}

//Subclasse Funcionario
class Funcionario extends Pessoa {
    private String nome;
    private double salario;
    private String departamento;

    public Funcionario(String cpf, String dataNascimento, String nome, double salario, String departamento) {
        super(cpf, dataNascimento); //aqui chama o construtor da superclasse, ou seja, da classe Pessoa
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public void mostrarDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário: " + salario);
        System.out.println("Departamento: " + departamento);
        System.out.println("CPF: " + getCpf());
        System.out.println("Data de Nascimento: " + getDataNascimento());
    }

    public void baterPonto() {
        System.out.println(nome + " bateu o ponto.");
    }
}

//Sub subclasse Gerente (essa nomenclatuara existe?)
// Não sei se existe, mas faz muito mais sentido do que subclasse, já que é uma subclasse de uma subclasse
class Gerente extends Funcionario {
    public Gerente(String cpf, String dataNascimento, String nome, double salario, String departamento) {
        super(cpf, dataNascimento, nome, salario, departamento); //ja expliquei pra que serve essa parada
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados(); //mema coisa só que pra fução
        System.out.println("Cargo: Gerente");
    }

    public void realizarReuniao() {
        System.out.println(getCpf() + " está realizando uma reunião.");
    }
}

//Sub subclasse Desenvolvedor
class Desenvolvedor extends Funcionario {
    public Desenvolvedor(String cpf, String dataNascimento, String nome, double salario, String departamento) {
        super(cpf, dataNascimento, nome, salario, departamento); //mema coisa de novo
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados(); //de novo mema coisa
        System.out.println("Cargo: Desenvolvedor");
    }

    public void programar() {
        System.out.println(getCpf() + " está programando.");
    }
}

//Sub subclasse Estagiario
class Estagiario extends Funcionario {
    public Estagiario(String cpf, String dataNascimento, String nome, double salario, String departamento) {
        super(cpf, dataNascimento, nome, salario, departamento); //mema coisa de novo
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados(); //de novo mema coisa
        System.out.println("Cargo: Estagiário");
    }

    public void fazerTarefa() {
        System.out.println(getCpf() + " está fazendo uma tarefa."); //sepre estagiario que se ferra
    }
}