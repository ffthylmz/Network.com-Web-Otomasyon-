
Merhaba, proje hakkında genel bir bilgi vermek istiyorum.
Öncelikler aşağıdaki sıra ile işlemleri yaparsanız projenin daha düzgün çalışacağını düşünüyorum.

1) network.com/src/main/resources/username-password files kalsörü içinde username.csv ve passqord.csv dosyalarını bulabilirsiniz.

2) network.com/src/main/java/pages/ReadUsernamePassword class'ı içinde de Path ve File kütüphaneleri ile oluşturduğumuz dosyalar
içindeki kullanıcı adı ve şifreyi ayrı ayrı metodlaştırdım.

3) BasePage class'ı içinde sıklıkla kullanacağımı düşündüğüm metodlarımı tanımladım ve bu class'ı tüm class'lara
inherit verdim.

4) network.com/src/test/java/Test_Base class'ını tanımladım ve tarayıcıyı-projeyi ayağa kaldırmak için gerekli olan
komutları yazdım.

5) network.com/src/test/java/Network_Test_Scenario class'ında ise "SearchProductPage" ve "SelectAndAddPage" classlarında
proje pdf'ine bağlı kalarak sırayla adımlarımı metod metod oluşturup @Test ve @Order() annotation'ları ile yazdım.