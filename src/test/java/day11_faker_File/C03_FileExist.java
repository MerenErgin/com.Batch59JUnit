package day11_faker_File;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        // bana icinde oldugum projenin dosya yolunu(path) verir
        // C:\Users\meren\IdeaProjects\com.Batch59JUnit

        System.out.println(System.getProperty("user.home"));
        //C:\Users\PC yani benim bilgisayarimin bana ozel kismini verdi7

        //C:\Users\hpi5\Downloads
        //C:\Users\ahka1\Downloads
        //C:\Users\HP\Downloads
        //homePath+ \Downloads

        //Masa ustumuzdeki text dosyasinin varligini test edin
        //C:\Users\meren\OneDrive\Desktop\text.txt
        String dosyaYolu= System.getProperty("user.home")+"\\OneDrive\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
        javada dosyaya erisim icin dosya yoluna yani path e ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan masa ustu
        dosya yoluda birbirinden farkli olacaktir
        testlerimizin tum bilgisayarlarda calismasi icin
        dosya yolunu DINAMIK yapmak zorundayiz
        */
        //bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim= System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim="\\OneDrive\\Desktop\\text.txt";
        //bazi bilgisayarlarda \\OneDrive kismi yok
        //mac icin txt uzantisi yok

        String masaustuDosyaYolu= farkliKisim+ortakKisim;

        System.out.println(Files.exists(Paths.get(masaustuDosyaYolu)));


    }
}
