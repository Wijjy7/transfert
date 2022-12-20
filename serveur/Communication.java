
import java.io.*;
import java.net.*;

class Communication extends Thread implements Runnable{
    public Communication(Socket connect, int g) throws IOException {
        SocketConnection = connect;
        g = connecte;
    }

    public void run() {

        try {
        
            in = new BufferedReader(new InputStreamReader(SocketConnection
                    .getInputStream()));
            out = new PrintWriter(SocketConnection.getOutputStream(), true);
          
            File f = new File("");
            String chemin = f.getAbsolutePath();
            File f2 = new File(chemin);
            System.out.println(chemin);
            File[] currentDirectoryFile = f2.listFiles();
            out.println(currentDirectoryFile.length);
            for (int i = 0; i < currentDirectoryFile.length; i++) {

                out.println(i + " : " + currentDirectoryFile[i] + " taille :"
                        + currentDirectoryFile[i].length());

            }

            saisie2 = Integer.parseInt(in.readLine());

            System.out.println("saisie du connecte n� " + connecte + ": "+ saisie2);

            File toDownload = currentDirectoryFile[saisie2];
            System.out.println("\nfichier choisie : " + toDownload.toString()
                    + " taille de celui ci :" + toDownload.length());
            //envoie des information relative au fichier pour commencer le
            // telechargement
            out.println("\n" + saisie2 + "|" + toDownload.toString() + "|"
                    + toDownload.length());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public BufferedReader in;

    public PrintWriter out;

    public int saisie2;



    public Socket SocketConnection;

    public int connecte;
}