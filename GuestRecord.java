import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import Model.EventOrganizer;

public class GuestRecord {
    //objek untuk input
    static Scanner input_pilihan = new Scanner(System.in);
    static BufferedReader input_data_tamu = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        //variabel untuk menyimpan data
        boolean ulang = true;
        char input_pilihan_menu;
        int jumlah_tamu;
        EventOrganizer[] daftar_tamu = new EventOrganizer[0];

        while (ulang) {
            //header program biar keren aja sih
            System.out.println("================================================");
            System.out.println("================ Program Undang ================");
            System.out.println("================================================");
            System.out.println("Pilih Menu");
            System.out.println("a.input data");
            System.out.println("b.cetak data");
            System.out.println("c.exit");
            System.out.print("pilih : ");
            input_pilihan_menu = input_pilihan.next().charAt(0);

            switch (input_pilihan_menu) {
                case 'a':
                    try {
                        System.out.print("\njumlah tamu : ");
                        jumlah_tamu = Integer.parseInt(input_data_tamu.readLine());
                        daftar_tamu = new EventOrganizer[jumlah_tamu];
                        InputTamuUndangan(daftar_tamu);
                    } catch (Exception e) {
                        System.out.println("ERROR kesalahan disisi user!\n");
                    }
                    break;

                case 'b':
                    if (daftar_tamu.length == 0 || daftar_tamu[0] == null) {
                        System.out.println("\nData Guest kosong mohon untuk isi dahulu!\n");
                    }else{
                        //mengubah array ke arraylist dulu karena di sini pake array di sana pake arraylist :(
                        ArrayList<EventOrganizer> para_tamu = new ArrayList<EventOrganizer>(Arrays.asList(daftar_tamu));
                        EventOrganizer.PrintGuests(para_tamu);
                    }
                    break;

                case 'c':
                    ulang = false;
                    break;
            
                default:
                    System.out.println("\nmohon pilih huruf yang ada di menu!\n");
                    break;
            }
        }
    }

    private static void InputTamuUndangan(EventOrganizer[] daftar_tamu) {
        System.out.println("\n================== Input Data ==================");
        try {
            for (int index = 0; index < daftar_tamu.length; index++) {
                EventOrganizer tamu = new EventOrganizer(); //membuat objek tamu baru untuk ditambahkan ke daftar

                //memasukan semua nilai properti dalam objek tamu yang baru
                System.out.println("ID\t: " + (index+1));
                tamu.setID(index+1);

                System.out.print("Nama\t: ");
                tamu.setNAMA(input_data_tamu.readLine());

                System.out.print("Alamat\t: ");
                tamu.setALAMAT(input_data_tamu.readLine());

                System.out.print("Email\t: ");
                tamu.setEMAIL(input_data_tamu.readLine());

                System.out.print("No HP\t: ");
                tamu.setNO_HP(input_data_tamu.readLine());

                if(index != daftar_tamu.length-1){
                    System.out.println("");
                }

                daftar_tamu[index] = tamu; //menambahkan objek tamu baru ke array daftar tamu
            }
            System.out.println("================================================\n");
        } catch (Exception e) {
            System.out.println("ERROR kesalahan di sisi user!\n");
        }
    }
}