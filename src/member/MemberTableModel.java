/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package member; // Mendefinisikan package 'member' untuk kelas-kelas terkait dengan anggota.

import javax.swing.table.*; // Mengimpor kelas AbstractTableModel dari paket javax.swing.table untuk mendefinisikan model tabel.
import java.util.List; // Mengimpor kelas List dari paket java.util untuk menangani koleksi data.

/**
 *
 * @author alvarez // Komentar yang menyatakan penulis kelas ini.
 */
public class MemberTableModel extends AbstractTableModel { // Mendefinisikan kelas MemberTableModel yang mengimplementasikan AbstractTableModel.

    private String[] columnNames = {"Nama", "Jenis Member"}; // Array untuk menyimpan nama kolom tabel.
    private List<Member> data; // List untuk menyimpan data anggota.

    public MemberTableModel(List<Member> data) { // Konstruktor kelas MemberTableModel.
        this.data = data; // Menginisialisasi data dengan nilai yang diberikan.
    }

    public int getColumnCount() { // Metode untuk mendapatkan jumlah kolom pada tabel.
        return columnNames.length; // Mengembalikan panjang array columnNames.
    }

    public int getRowCount() { // Metode untuk mendapatkan jumlah baris pada tabel.
        return data.size(); // Mengembalikan jumlah data yang disimpan dalam list.
    }

    public String getColumnName(int col) { // Metode untuk mendapatkan nama kolom pada indeks tertentu.
        return columnNames[col]; // Mengembalikan nama kolom pada indeks yang diberikan.
    }

    public Object getValueAt(int row, int col) { // Metode untuk mendapatkan nilai pada sel tabel tertentu.
        Member rowItem = data.get(row); // Mendapatkan data anggota pada indeks baris yang diberikan.
        String value = ""; // Inisialisasi nilai default.

        switch (col) { // Memeriksa indeks kolom.
            case 0:
                value = rowItem.getNama(); // Mendapatkan nilai nama anggota.
                break;
            case 1:
                value = rowItem.getJenisMember().getNama(); // Mendapatkan nilai jenis anggota.
                break;
        }
        return value; // Mengembalikan nilai pada sel tabel.
    }

    public boolean isCellEditable(int row, int col) { // Metode untuk menentukan apakah sel tabel dapat diubah.
        return false; // Mengembalikan false karena sel tabel tidak dapat diubah.
    }

    public void add(Member value) { // Metode untuk menambahkan data anggota ke dalam tabel.
        data.add(value); // Menambahkan data anggota ke dalam list.
        fireTableRowsInserted(data.size() - 1, data.size() - 1); // Memberitahukan tabel bahwa baris telah ditambahkan.
    }

}
