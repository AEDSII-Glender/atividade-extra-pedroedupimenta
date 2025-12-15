import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppPlaylist {

    public static void main(String[] args) {

        Playlist playlist = new Playlist();
        Historico historico = new Historico();
        Buscador buscador = new Buscador();

        File arquivo = new File("musicas.txt");

        System.out.println("Procurando em: " + arquivo.getAbsolutePath());
        System.out.println("Existe? " + arquivo.exists());

        try {
            Scanner leitor = new Scanner(arquivo);

            while (leitor.hasNextLine()) {
                String linha = leitor.nextLine().trim();
                if (linha.isEmpty() || !linha.contains(";")) {
                    continue;
                }

                String[] dados = linha.split(";");

                if (dados.length < 4) {
                    continue;
                }

                int id = Integer.parseInt(dados[0].trim());
                String nome = dados[1].trim();
                String artista = dados[2].trim();
                double duracao = Double.parseDouble(
                        dados[3].trim().replace(",", ".")
                );

                Musica musica = new Musica(id, nome, artista, duracao);
                buscador.inserir(musica);
            }

            leitor.close();

        } catch (FileNotFoundException e) {
            System.out.println("Arquivo musicas.txt não encontrado.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== PLAYLIST =====");
            System.out.println("1 - Adicionar música à playlist");
            System.out.println("2 - Remover música da playlist");
            System.out.println("3 - Reproduzir música");
            System.out.println("4 - Exibir playlist");
            System.out.println("5 - Voltar reprodução");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> {
                    System.out.print("ID da música: ");
                    int id = sc.nextInt();
                    Musica m = buscador.buscar(id);

                    if (m != null) {
                        playlist.adicionar(m);
                        System.out.println("Música adicionada.");
                    } else {
                        System.out.println("Música não encontrada.");
                    }
                }

                case 2 -> {
                    System.out.print("ID da música para remover: ");
                    int id = sc.nextInt();

                    if (playlist.removerPorId(id)) {
                        System.out.println("Música removida.");
                    } else {
                        System.out.println("Música não está na playlist.");
                    }
                }

                case 3 -> {
                    System.out.print("ID da música para reproduzir: ");
                    int id = sc.nextInt();
                    Musica m = buscador.buscar(id);

                    if (m != null) {
                        System.out.println("Reproduzindo: " + m);
                        historico.registrar(m);
                    } else {
                        System.out.println("Música não encontrada.");
                    }
                }

                case 4 -> playlist.exibir();
                case 5 -> historico.voltar();
            }

        } while (opcao != 0);

        sc.close();
    }
}
