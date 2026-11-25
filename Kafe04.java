// import java.util.Scanner;
// public class Kafe04 {
//     public static void Menu(String namaPelanggan, boolean isMember, int jamKunjung) {
//         System.out.println("Selamat datang, " + namaPelanggan + "!");

//         if (isMember) {
//             System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
//         }
//         if (jamKunjung >= 14 && jamKunjung <= 16) {
//             System.out.println("Happy Hour! Diskon 20% untuk semua minuman");
//         }
//         System.out.println("===== MENU RESTO KAFE =====");
//         System.out.println("1. Kopi Hitam - Rp 15,000");
//         System.out.println("2. Cappuccino - Rp 20,000");
//         System.out.println("3. Latte - Rp 22,000");
//         System.out.println("4. Teh Tarik - Rp 12,000");
//         System.out.println("5. Roti Bakar - Rp 10,000");
//         System.out.println("6. Mie Goreng - Rp 18,000");
//         System.out.println("===========================");
//         System.out.println("Silakan pilih menu yang Anda inginkan.");
//     }
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Masukkan nama pelanggan: ");
//         String namaPelanggan = sc.nextLine();

//         System.out.print("Apakah member? (y/n): ");
//         String inputMember = sc.next();
//         boolean isMember = inputMember.equalsIgnoreCase("y");

//         System.out.print("Masukkan jam kunjung (0-23): ");
//         int jamKunjung = sc.nextInt();

//         Menu(namaPelanggan, isMember, jamKunjung);
//     }
// }
import java.util.Scanner;

public class Kafe04 {
    public static void Menu(String namaPelanggan, boolean isMember) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga04(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;
        return hargaTotal;
    }

    public static int hitungDiskon(int total, String kodePromo, boolean isMember) {
        int persenDiskon = 0;

        if (kodePromo.equals("DISKON50")) {
            persenDiskon += 50;
        } else if (kodePromo.equals("DISKON30")) {
            persenDiskon += 30;
        } else {
            System.out.println("Kode promo invalid");
        }

        if (isMember) {
            persenDiskon += 10;
        }

        return (total * persenDiskon) / 100;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String namaPelanggan = "Andi";
        boolean isMember = true;
        Menu(namaPelanggan, isMember);

        int totalKeseluruhan = 0;
        String lanjut;

        do {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan (1-6): ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Menu tidak tersedia! Silakan pilih menu yang tersedia.");
            } else {
                System.out.print("Masukkan jumlah item yang ingin dipesan: ");
                int banyakItem = sc.nextInt();

                int subtotal = hitungTotalHarga04(pilihanMenu, banyakItem);
                totalKeseluruhan += subtotal;
                System.out.println("Subtotal item ini: Rp" + subtotal);
            }

            System.out.print("Apakah ingin memesan menu lain? (y/n): ");
            lanjut = sc.next();
        } while (lanjut.equalsIgnoreCase("y"));

        System.out.print("\nMasukkan kode promo: ");
        String kodePromo = sc.next();
        int besarDiskon = hitungDiskon(totalKeseluruhan, kodePromo, isMember);
        int totalBayar = totalKeseluruhan - besarDiskon;

        System.out.println("\n--- Ringkasan Pembayaran ---");
        System.out.println("Total harga   : Rp" + totalKeseluruhan);
        System.out.println("Besar diskon  : Rp" + besarDiskon);
        System.out.println("Total bayar   : Rp" + totalBayar);

        sc.close();
    }
}