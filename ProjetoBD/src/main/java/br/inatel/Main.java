package br.inatel;
import br.inatel.DAO.*;
import br.inatel.Model.*;
import br.inatel.Model.Pedido;

import java.util.List;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ClienteDAO clienteDAO = new ClienteDAO();
        MesaDAO mesaDAO = new MesaDAO();
        PratoDAO pratoDAO = new PratoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        Pedido_has_PratoDAO pedido_has_pratoDAO = new Pedido_has_PratoDAO();

        while (true) {

            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar -- pessoa/prato/pedido");
            System.out.println("2. Buscar -- pessoa/prato/pedido");
            System.out.println("3. Atualizar -- pessoa/prato/pedido");
            System.out.println("4. Excluir -- pessoa/prato/pedido");
            System.out.println("5. Cadastrar item em um pedido");
            System.out.println("6. Buscar item em um pedido");
            System.out.println("7. Atualizar item em um pedido");
            System.out.println("8. Excluir item de um pedido");
            System.out.println("9. Encerrar");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1: // Cadastro
                System.out.println("\nEscolha o que deseja cadastrar:");
                System.out.println("1. Cliente");
                System.out.println("2. Mesa");
                System.out.println("3. Prato");
                System.out.println("4. Pedido");

                int tipo = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer da linha

                switch (tipo) {
                    case 1:
                        System.out.println("Entre com o seu nome: ");
                        String nome = scanner.nextLine();
                        System.out.println("Entre com o seu CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.println("Entre com o seu telefone: ");
                        String telefone = scanner.nextLine();
                        System.out.println("Entre com o seu email: ");
                        String email = scanner.nextLine();
                        Cliente cliente = new Cliente(0, nome, cpf, telefone, email);
                        if (clienteDAO.insertUser(cliente)) {
                            System.out.println("Cliente cadastrado com sucesso.");
                        } else {
                            System.out.println("Erro ao cadastrar o cliente.");
                        }
                        break;
                    case 2:
                        System.out.println("Entre com o numero da mesa: ");
                        int numero = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer da linha
                        System.out.println("Entre com a capacidade da mesa: ");
                        int capacidade = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer da linha
                        Mesa mesa = new Mesa(0, numero, capacidade);
                        if (mesaDAO.insertMesa(mesa)) {
                            System.out.println("Mesa cadastrada com sucesso.");
                        } else {
                            System.out.println("Erro ao cadastrar a mesa.");
                        }
                        break;
                    case 3:
                        System.out.println("Entre com o nome do prato: ");
                        String nomePrato = scanner.nextLine();
                        System.out.println("Entre com o preço do prato: ");
                        double preco = scanner.nextDouble();
                        scanner.nextLine(); // Limpar o buffer da linha
                        Prato prato = new Prato(0, nomePrato, preco);
                        if (pratoDAO.insertPrato(prato)) {
                            System.out.println("Prato cadastrado com sucesso.");
                        } else {
                            System.out.println("Erro ao cadastrar o prato.");
                        }
                        break;
                    case 4:
                        System.out.println("Entre com o ID da Mesa: ");
                        int idMesa = scanner.nextInt();
                        System.out.println("Entre com o ID do Cliente: ");
                        int idCliente = scanner.nextInt();
                        scanner.nextLine(); // Limpar o buffer da linha
                        System.out.println("Entre com a data: ");
                        String data = scanner.nextLine();
                        Pedido pedido = new Pedido(0, idMesa, idCliente, data);
                        if (pedidoDAO.insertPedido(pedido)) {
                            System.out.println("Pedido cadastrado com sucesso.");
                        } else {
                            System.out.println("Erro ao cadastrar o pedido.");
                        }
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
                break;

                case 2:

                    System.out.println("\nEscolha o tipo para buscar:");
                    System.out.println("1. Cliente");
                    System.out.println("2. Mesa");
                    System.out.println("3. Prato");
                    System.out.println("4. Pedido");

                    int buscar = scanner.nextInt();
                    scanner.nextLine();

                    switch (buscar) {
                        case 1:

                            System.out.println("Entre com o id do cliente que deseja buscar:");
                            int id = scanner.nextInt();
                            Cliente cliente = clienteDAO.selectUser().stream()
                                    .filter(c -> c.getIdCliente() == id)
                                    .findFirst()
                                    .orElse(null);
                            if (cliente != null) {
                                System.out.println("Cliente encontrado: " + cliente);
                            } else {
                                System.out.println("Cliente não encontrado.");
                            }
                            break;
                        case 2:

                            System.out.println("Entre com o id do cliente que deseja buscar:");
                            int id1 = scanner.nextInt();
                            Mesa mesa = mesaDAO.selectMesas().stream()
                                    .filter(m -> m.getIdMesa() == id1)
                                    .findFirst()
                                    .orElse(null);
                            if (mesa != null) {
                                System.out.println("Mesa encontrada: " + mesa);
                            } else {
                                System.out.println("Mesa não encontrada.");
                            }
                            break;
                        case 3:

                            System.out.println("Entre com o id do prato que deseja buscar:");
                            int id2 = scanner.nextInt();
                            Prato prato = pratoDAO.selectPratos().stream()
                                    .filter(p -> p.getIdPrato() == id2)
                                    .findFirst()
                                    .orElse(null);
                            if (prato != null) {
                                System.out.println("Prato encontrado: " + prato);
                            } else {
                                System.out.println("Prato não encontrado.");
                            }
                            break;
                        case 4:

                            System.out.println("Entre com o id do pedido que deseja buscar:");
                            int id3 = scanner.nextInt();
                            Pedido pedido = pedidoDAO.selectPedido().stream()
                                    .filter(p -> p.getIdPedido() == id3)
                                    .findFirst()
                                    .orElse(null);
                            if (pedido != null) {
                                System.out.println("Pedido encontrado: " + pedido);
                            } else {
                                System.out.println("Pedido não encontrado.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }

                    break;
                case 3:

                    System.out.println("\nEscolha o tipo para atualizar:");
                    System.out.println("1. Cliente");
                    System.out.println("2. Mesa");
                    System.out.println("3. Prato");
                    System.out.println("4. Pedido");

                    int atualizar = scanner.nextInt();
                    scanner.nextLine();

                    switch (atualizar) {
                        case 1:

                            System.out.println("Entre com o id do cliente que deseja atualizar:");
                            int id1 = scanner.nextInt();

                            scanner.nextLine();

                            System.out.println("Entre com o nome atualizado:");
                            String nome = scanner.nextLine();

                            System.out.println("Entre com o CPF atualizado:");
                            String cpf = scanner.nextLine();

                            System.out.println("Entre com o telefone atualizado:");
                            String telefone = scanner.nextLine();

                            System.out.println("Entre com o email atualizado:");
                            String email = scanner.nextLine();

                            Cliente cliente = new Cliente(id1, nome, cpf, telefone, email);
                            if (clienteDAO.updateUser(id1, cliente)) {
                                System.out.println("Cliente atualizado com sucesso.");
                            } else {
                                System.out.println("Erro ao atualizar o cliente.");
                            }
                            break;
                        case 2:

                            System.out.println("Entre com o id da mesa que deseja atualizar:");
                            int id2 = scanner.nextInt();

                            System.out.println("Entre com o numero atualizado da mesa: ");
                            int numero = scanner.nextInt();

                            System.out.println("Entre com a capacidade atualizada da mesa: ");
                            int capacidade = scanner.nextInt();
                            Mesa mesa = new Mesa(id2, numero, capacidade);
                            if (mesaDAO.updateMesa(id2, mesa)) {
                                System.out.println("Mesa atualizada com sucesso.");
                            } else {
                                System.out.println("Erro ao atualizar a mesa.");
                            }
                            break;
                        case 3:

                            System.out.println("Entre com o id do prato que deseja atualizar:");
                            int id3 = scanner.nextInt();
                            scanner.nextLine();

                            System.out.println("Entre com o nome atualizado do prato: ");
                            String nome1 = scanner.nextLine();

                            System.out.println("Entre com o preço atualizado do prato: ");
                            double preco = scanner.nextDouble();

                            Prato prato = new Prato(id3, nome1, preco);
                            if (pratoDAO.updatePrato(id3, prato)) {
                                System.out.println("Prato atualizado com sucesso.");
                            } else {
                                System.out.println("Erro ao atualizar o prato.");
                            }
                            break;
                        case 4:

                            System.out.println("Entre com o id do pedido que deseja atualizar:");
                            int id4 = scanner.nextInt();

                            System.out.println("Entre com o id atualizado do cliente");
                            int idcliente = scanner.nextInt();

                            System.out.println("Entre com o id da atualizado da mesa ");
                            int idmesa = scanner.nextInt();

                            scanner.nextLine();

                            System.out.println("Entre com a data atualizada do prato: ");
                            String data = scanner.nextLine();

                            Pedido pedido = new Pedido(id4, idcliente, idmesa, data);
                            if (pedidoDAO.updatePedido(id4, pedido)) {
                                System.out.println("Pedido atualizado com sucesso.");
                            } else {
                                System.out.println("Erro ao atualizar o pedido.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }

                    break;
                case 4:

                    System.out.println("\nEscolha o tipo para excluir:");
                    System.out.println("1. Cliente");
                    System.out.println("2. Mesa");
                    System.out.println("3. Prato");
                    System.out.println("4. Pedido");

                    int excluir = scanner.nextInt();
                    scanner.nextLine();

                    switch (excluir) {
                        case 1:

                            System.out.println("Entre com o id do cliente que deseja excluir:");
                            int id = scanner.nextInt();
                            if (clienteDAO.deleteUser(id)) {
                                System.out.println("Cliente excluído com sucesso.");
                            } else {
                                System.out.println("Erro ao excluir o cliente.");
                            }
                            break;
                        case 2:

                            System.out.println("Entre com o id da mesa que deseja excluir:");
                            int id1 = scanner.nextInt();
                            if (mesaDAO.deleteMesa(id1)) {
                                System.out.println("Mesa excluída com sucesso.");
                            } else {
                                System.out.println("Erro ao excluir a mesa.");
                            }
                            break;
                        case 3:

                            System.out.println("Entre com o id do prato que deseja excluir:");
                            int id2 = scanner.nextInt();
                            if (pratoDAO.deletePrato(id2)) {
                                System.out.println("Prato excluído com sucesso.");
                            } else {
                                System.out.println("Erro ao excluir o prato.");
                            }
                            break;
                        case 4:

                            System.out.println("Entre com o id do pedido que deseja excluir:");
                            int id3 = scanner.nextInt();
                            if (pedidoDAO.deletePedido(id3)) {
                                System.out.println("Pedido excluído com sucesso.");
                            } else {
                                System.out.println("Erro ao excluir o pedido.");
                            }
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }

                    break;
                case 5:

                    System.out.println("Entre com o id do pedido que deseja cadastrar pratos");
                    int idPedido = scanner.nextInt();
                    System.out.println("Entre com o id do prato que deseja cadastrar");
                    int idPrato = scanner.nextInt();
                    System.out.println("Entre com a quantidade que deseja cadastrar:");
                    int quantidade = scanner.nextInt();

                    Pedido_has_Prato itens = new Pedido_has_Prato(idPedido, idPrato, quantidade);

                    if (pedido_has_pratoDAO.insertItens(itens)) {
                        System.out.println("Item (Prato) adicionado ao pedido com sucesso.");
                    } else {
                        System.out.println("Erro ao adicionar o prato ao pedido.");
                    }

                    break;
                case 6:

                    System.out.println("Entre com o id do pedido para pesquisar os itens dele");
                    int idPedido1 = scanner.nextInt();
                    List<Pedido_has_Prato> itensPedido = pedido_has_pratoDAO.selectItens();
                    itensPedido.stream()
                            .filter(item -> item.getPedidoIdPedido() == idPedido1)
                            .forEach(item -> System.out.println("Prato ID: " + item.getPratoIdPrato() + ", Quantidade: " + item.getQuantidade()));

                    break;
                case 7:

                    System.out.println("Entre com o id do pedido que deseja atualizar");
                    int idPedido2 = scanner.nextInt();
                    System.out.println("Entre com o id do prato que deseja atualizar");
                    int idPrato1 = scanner.nextInt();
                    System.out.println("Entre com a quantidade atualizada");
                    int novaQuantidade = scanner.nextInt();

                    Pedido_has_Prato pedidoHasPrato = new Pedido_has_Prato(idPedido2, idPrato1, novaQuantidade);

                    if (pedido_has_pratoDAO.updateItens(idPedido2, pedidoHasPrato)) {
                        System.out.println("Item (Prato) atualizado no pedido com sucesso.");
                    } else {
                        System.out.println("Erro ao atualizar o item no pedido.");
                    }

                    break;
                case 8:

                    System.out.println("Entre com o id do pedido que deseja excluir");
                    int idPedido3 = scanner.nextInt();

                    System.out.println("Entre com o id do prato que deseja excluir");
                    int idPedido4 = scanner.nextInt();

                    if (pedido_has_pratoDAO.deleteItens(idPedido3, idPedido4)) {
                        System.out.println("Item (Prato) removido do pedido com sucesso.");
                    } else {
                        System.out.println("Erro ao remover o item do pedido.");
                    }

                    break;
                case 9:
                    System.out.println("Programa encerrado");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

}



