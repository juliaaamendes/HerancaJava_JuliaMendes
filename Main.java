import java.util.ArrayList;
import java.util.Scanner;


//classe main
public class Main {
    public static void main(String[] args) { //♪ public static void main ♪
        Scanner scanner = new Scanner(System.in);
        ArrayList<Funcionario> funcionarios = new ArrayList<>(); //aqui ta criando a listinha de funcionarios

        while (true) { //loop do menuzinho
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Exibir Funcionários");
            System.out.println("3. Registro de Trabalho");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); //pra nao bugar o scanner

            if (opcao == 1) {
                System.out.print("Digite o CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Digite a Data de Nascimento: ");
                String dataNascimento = scanner.nextLine();
                System.out.print("Digite o Nome: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o Salário: ");
                double salario = scanner.nextDouble();
                scanner.nextLine(); //de novo pra nao bugar o scanner
                System.out.print("Digite o Departamento: ");
                String departamento = scanner.nextLine();

                System.out.println("Escolha o tipo de funcionário:");
                System.out.println("1. Gerente");
                System.out.println("2. Desenvolvedor");
                System.out.println("3. Estagiário");
                int tipo = scanner.nextInt();
                scanner.nextLine(); //mema coisa de novo

                Funcionario funcionario = null; //aqui eu tenho só a ideia de contrar um funcionario, vulgo crie mas nao instancie
                //aqui eu to instanciando o funcionario de acordo com o tipo que o usuario escolheu, vulgo to tirando a ideia do papel e contratando o funcionario
                if (tipo == 1) {
                    funcionario = new Gerente(cpf, dataNascimento, nome, salario, departamento);
                } else if (tipo == 2) {
                    funcionario = new Desenvolvedor(cpf, dataNascimento, nome, salario, departamento);
                } else if (tipo == 3) {
                    funcionario = new Estagiario(cpf, dataNascimento, nome, salario, departamento);
                }

                if (funcionario != null) {
                    funcionarios.add(funcionario);
                    //se um funcionario foi contratado de verdade, pimba, mensagem bonitinha
                    System.out.println("Funcionário cadastrado com sucesso!"); 
                } else {
                    System.out.println("Tipo de funcionário inválido."); //se o funcionario nao foi contratado, pimba, mensagem de erro
                }
            } else if (opcao == 2) {
                //aqui eu to checando se a lista de funcionarios ta vazia, se sim, mensagem de erro de novo
                if (funcionarios.isEmpty()) { 
                    System.out.println("Nenhum funcionário cadastrado.");
                } else {
                    //se a lista de funcionarios nao ta vazia, mensagem bonitinha e mostra os funcionarios
                    System.out.println("Temos " + funcionarios.size() + " funcionários cadastrados:");
                    int contador = 1; //variavel pra contar os funcionarios
                    for (Funcionario f : funcionarios) {
                        System.out.println(contador + "°");
                        f.mostrarDados();
                        System.out.println();
                        contador++;
                    }
                }
            } else if (opcao == 3) {
                if (funcionarios.isEmpty()) { //vendo se tem pelo menos um funcionario cadastrado
                    System.out.println("Nenhum funcionário cadastrado.");
                } else {
                    System.out.println("Escolha um funcionário para registrar o trabalho:");
                    int contador = 1;
                    for (Funcionario f : funcionarios) { //aqui eu to mostrando os funcionarios cadastrados, seu cargo e cpf
                        System.out.println(contador + ". " + f.getClass().getSimpleName() + " - " + f.getCpf());
                        contador++;
                    }
            
                    System.out.print("Digite o número do funcionário: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine(); //pro scanner nao bugar de novo
            
                    if (escolha > 0 && escolha <= funcionarios.size()) {
                        Funcionario escolhido = funcionarios.get(escolha - 1);
                        escolhido.baterPonto();
            
                        //verifica o tipo do funcionario e executa a tarefa especifica
                        if (escolhido instanceof Gerente) {
                            ((Gerente) escolhido).realizarReuniao();
                        } else if (escolhido instanceof Desenvolvedor) {
                            ((Desenvolvedor) escolhido).programar();
                        } else if (escolhido instanceof Estagiario) {
                            ((Estagiario) escolhido).fazerTarefa();
                        }
                    } else if (opcao == 0) {
                    System.out.println("Saindo...");
                    break;
                    } else {
                        System.out.println("Funcionário inválido."); //se o funcionario nao foi escolhido, pimba, mensagem de erro
                    }
                }
                System.out.println("Opção inválida."); //outra mensagem de erro pro usuario deixar de ser burro e escolher uma opção valida
            }
        } scanner.close(); //fechando o scanner pra nao dar erro de memoria depois
    }
}