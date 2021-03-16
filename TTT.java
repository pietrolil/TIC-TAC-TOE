

import java.util.Scanner;

  class TTT {  
    public static char[][] initialize( ) {
      char matriz[][] = new char[3][3];
      for(int i = 0;i < 3; i++){
        for(int j = 0; j < 3; j++){
          matriz[i][j] = '-';
        }
      }
      return matriz;
    }
    public static boolean step (char M[][], int lin, int col, char gamer){
      if(M[lin][col] == '-'){
        M[lin][col] = gamer;
        return true;
      }else{
        System.out.println("Posição inválida!");
        return false;
      }
    }
    public static int status (char M[][]) {
      boolean checalinhasX, checalinhasO, checacolunasX, checacolunasO, checaDiagonalX, checaDiagonalO, checaVelha;

      checalinhasX = ((M[0][0] == 'X' && M[0][1] == 'X' && M[0][2] == 'X') || (M[1][0] == 'X' && M[1][1] == 'X' && M[1][2] == 'X') || (M[2][0] == 'X' && M[2][1] == 'X' && M[2][2] == 'X'));
      checalinhasO = ((M[0][0] == 'O' && M[0][1] == 'O' && M[0][2] == 'O') || (M[1][0] == 'O' && M[1][1] == 'O' && M[1][2] == 'O') || (M[2][0] == 'O' && M[2][1] == 'O' && M[2][2] == 'O'));
      checacolunasX = ((M[0][0] == 'X' && M[1][0] == 'X' && M[2][0] == 'X') || (M[0][1] == 'X' && M[1][1] == 'X' && M[2][1] == 'X') || (M[0][2] == 'X' && M[1][2] == 'X' && M[2][2] == 'X'));
      checacolunasO = ((M[0][0] == 'O' && M[1][0] == 'O' && M[2][0] == 'O') || (M[0][1] == 'O' && M[1][1] == 'O' && M[2][1] == 'O') || (M[0][2] == 'O' && M[1][2] == 'O' && M[2][2] == 'O'));
      checaDiagonalX = ((M[0][0] == 'X' && M[1][1] == 'X' && M[2][2] == 'X') || (M[0][2] == 'X' && M[1][1] == 'X' && M[2][0] == 'X'));
      checaDiagonalO = ((M[0][0] == 'O' && M[1][1] == 'O' && M[2][2] == 'O') || (M[0][2] == 'O' && M[1][1] == 'O' && M[2][0] == 'O'));
      checaVelha = (M[0][0] != '-' && M[0][1] != '-' && M[0][2] != '-' && M[1][0] != '-' && M[1][1] != '-' && M[1][2] != '-' && M[2][0] != '-' && M[2][1] != '-' && M[2][2] != '-');
      if(checaDiagonalO || checalinhasO || checacolunasO){
        return 1;
      }
      else if(checaDiagonalX || checalinhasX || checacolunasX){
        return 2;
      }
      else if(checaVelha){
        return 0;
      }
      else{
        return -1;
      }
    }
    

    public static void game(){
      System.out.println("Bem vindo ao jogo da Velha 3x3");
      char matriz[][] = initialize();
      System.out.println("O jogador O Começa jogando");
      int i = 0;
      char gamer = '-';
      Scanner sc1 = new Scanner(System.in);
      boolean passou;
      int col, lin,situacao;

      while(i < 9){
        if(i % 2 == 0){
          printBoard(matriz);
          gamer = 'O';
          System.out.println("Jogador " + gamer + " escolha a linha:");
          lin = sc1.nextInt();
          System.out.println("Jogador " + gamer + " escolha a coluna:");
          col = sc1.nextInt();
          passou = step(matriz,lin,col,gamer);
          if(passou){
            if(i >= 4){
              situacao = status(matriz);
              switch (situacao){
                case -1:
                  System.out.println("O jogo continua");
                  break;
                case 0:
                  System.out.println("Deu velha!");
                  printBoard(matriz);
                  System.out.println("Obrigado por jogar");
                  System.exit(0);
                  break;
                case 1:
                  System.out.println("Jogador O venceu!");
                  printBoard(matriz);
                  System.out.println("Obrigado por jogar");
                  System.exit(0);
                  break;
                case 2:
                  System.out.println("Jogagor X venceu!");
                  printBoard(matriz);
                  System.out.println("Obrigado por jogar");
                  System.exit(0);
                  break;
            
              }
            
            }i = i + 1;
          }else{
            System.out.println("Tente novamente");
            
          }
        }else{
          printBoard(matriz);
          gamer = 'X';
          System.out.println("Jogador " + gamer + " escolha a linha:");
          lin = sc1.nextInt();
          System.out.println("Jogador " + gamer + " escolha a coluna:");
          col = sc1.nextInt();
          passou = step(matriz,lin,col,gamer);
          if(passou){
            if(i >4){
              situacao = status(matriz);
              switch (situacao){
                case -1:
                  System.out.println("O jogo continua");
                  break;
                case 0:
                  System.out.println("Deu velha!");
                  printBoard(matriz);
                  System.out.println("Obrigado por jogar");
                  System.exit(0);
                  break;
                case 1:
                  System.out.println("Jogador O venceu!");
                  printBoard(matriz);
                  System.out.println("Obrigado por jogar");
                  System.exit(0);
                  break;
                case 2:
                  System.out.println("Jogagor X venceu!");
                  printBoard(matriz);
                  System.out.println("Obrigado por jogar");
                  System.exit(0);
                  break;
            
              }
            
            }i = i + 1;
          }else{
            System.out.println("Tente novamente");
            
          } 
        }
      
      
      }
    
    }


    public static void printBoard(char M[][]){
      { 
        System.out.println("|---|---|---|"); 
        System.out.println("| " + M[0][0] + " | "
                            + M[0][1] + " | " + M[0][2] 
                            + " |"); 
        System.out.println("|-----------|"); 
        System.out.println("| " + M[1][0] + " | "
                            + M[1][1] + " | " + M[1][2] 
                            + " |"); 
        System.out.println("|-----------|"); 
        System.out.println("| " + M[2][0] + " | "
                            + M[2][1] + " | " + M[2][2] 
                            + " |"); 
        System.out.println("|---|---|---|"); 
    } 



  }

    public static void main(String args[]) { 
      game();
    } 

  }