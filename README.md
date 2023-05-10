
# Mayın Tarlası Oyunu

Bu proje, Java programlama dili kullanılarak geliştirilmiş bir Mayın Tarlası oyunudur. Oyun metin tabanlıdır ve çift boyutlu diziler üzerinde çalışır. Kullanıcının gireceği satır ve sütun sayısına göre bir matris oluşturulur ve bu matrise rastgele mayınlar yerleştirilir. Kullanıcının seçtiği noktaya komşu olan tüm hücrelerdeki mayınların sayısı hesaplanarak, ilgili noktaya yazdırılır. Kullanıcı herhangi bir mayına basmadan tüm noktaları seçebilirse oyun kazanılmış olur.

## Kurulum

Bu projeyi bilgisayarınıza klonlamak için şu adımları takip edebilirsiniz:

1. Bu sayfanın sağ üst köşesindeki "Code" butonuna tıklayın.
2. Açılan menüden "Download ZIP" seçeneğini seçin.
3. İndirilen ZIP dosyasını açın.
4. Dosya konumunuza gidin ve Terminal/Powershell/Komut Satırı açın.
5. Aşağıdaki komut ile proje klasörüne erişin:

```
cd path/to/folder
```

6. Proje klasörünün içindeki "src" klasörüne girin.
7. Aşağıdaki komut ile projeyi çalıştırın:

```
javac Main.java
java Main
```

## Nasıl Oynanır?

1. Oyun başladığında, kullanıcıdan satır ve sütun sayısı istenir.
2. Matris oluşturulduktan sonra, rastgele mayınlar yerleştirilir ve etrafındaki hücrelerdeki mayınların sayısı hesaplanarak yazdırılır.
3. Kullanıcı bir nokta seçer. Eğer seçilen noktada mayın varsa oyun kaybedilir. Eğer seçilen noktada mayın yoksa, ilgili noktaya değen tüm komşu hücrelerin incelenmesi gerekmektedir. Eğer o noktaya değen komşu hücrelerde de mayın yoksa, ilgili noktadaki matris elemanına "0" atanmakta ve etrafındaki diğer hücreler de açılmaktadır.
4. Kullanıcının hiç bir mayına basmadan tüm noktaları seçebilirse oyun kazanılmış olur.
5. Oyunu yeniden oynamak isterseniz, programın tekrardan çalıştırılması gerekir.

