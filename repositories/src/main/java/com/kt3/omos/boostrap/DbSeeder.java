package com.kt3.omos.boostrap;

import com.kt3.omos.domain.Category;
import com.kt3.omos.domain.Product;
import com.kt3.omos.domain.Student;
import com.kt3.omos.repositories.CategoryRepository;
import com.kt3.omos.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    StudentRepository studentRepository;
    @Autowired
    CategoryRepository categoryRepository;


    public DbSeeder(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private Long id;
//        private String code;
//        private String name;
//        private String description;
//        private String image;
//        private boolean status;
//        @ManyToOne
//        private Category parent;
//        @OneToMany(mappedBy = "parent")
//        private Set<Category> childs;
//        @OneToMany(mappedBy = "category")
//        private Set<Product> products;
//        @OneToMany(mappedBy = "category")
//        private Set<CategoryDiscount> categoryDiscounts;
        Category drink = new Category();
        drink.setCode("Thuc-uong");
        drink.setName("Thức uống");
        drink.setDescription("Danh sách tất cả các loại thức uống.");
        drink.setImage("");
        drink.setStatus(true);


        Category tea = new Category();
        tea.setCode("tra-tea");
        tea.setName("Trà");
        tea.setDescription("Tất cả các loại trà lấy từ nguyên liệu an toàn cho sức khoẻ.");
        tea.setImage("");
        tea.setStatus(true);
        tea.setParent(drink);

        Category milk = new Category();
        milk.setCode("sua-tea");
        milk.setName("Sữa");
        milk.setDescription("Tất cả các loại sữa từ sữa bột cho đến sữa tươi.");
        milk.setImage("");
        milk.setStatus(true);
        milk.setParent(drink);

        Category milkTea = new Category();
        milkTea.setCode("tra-sua-milktea");
        milkTea.setName("Trà Sữa");
        milkTea.setDescription("Trà Sữa dành cho mọi lứa tuổi.");
        milkTea.setImage("");
        milkTea.setStatus(true);
        milkTea.setParent(drink);

        Category coffee = new Category();
        coffee.setCode("ca-phe-coffee");
        coffee.setName("Cà phê");
        coffee.setDescription("Cà phê giúp tinh thần tỉnh táo hơn.");
        coffee.setImage("");
        coffee.setStatus(true);
        coffee.setParent(drink);

        //===============================
//        private Long id;
//        private String code;
//        private String name;
//        private String urlPath;
//        private String description;
//        private String thumbnail;
//        @ElementCollection
//        @CollectionTable(name = "PRODUCT_IMAGES")
//        @OrderColumn
//        private List<String> images;
//        private BigDecimal price;
//        private float avgRating;
//        private int quantity;
//        private boolean hotFlag;
//        private boolean status;
        Product traThai = new Product();
        traThai.setCode("Tra-xanh-Thai-Lan");
        traThai.setName("Trà xanh Thái Lan");
        traThai.setUrlPath("/tra-xanh-thai-lan");
        traThai.setDescription("Trà xanh Thái Lan được làm từ những ngọn chè xanh từ cùng cao nguyên Thái Lan ở tỉnh ChiangMai giúp loại bỏ gốc oxy tự do.");
        traThai.setPrice(BigDecimal.valueOf(900000L));
        traThai.setAvgRating(4.5f);
        traThai.setQuantity(100);
        traThai.setStatus(true);
        traThai.setHotFlag(false);
        //traThai.setCategory(tea);
        tea.addProduct(traThai);

        Product traOoLong = new Product();
        traOoLong.setCode("Tra-OoLong-Hao-Hang");
        traOoLong.setName("Trà Ô long");
        traOoLong.setUrlPath("/tra-oo-long");
        traOoLong.setDescription("Trà Ô long được làm từ những ngọn chè xanh từ cùng cao nguyên Thái Lan ở tỉnh ChiangMai giúp loại bỏ gốc oxy tự do.");
        traOoLong.setPrice(BigDecimal.valueOf(98000L));
        traOoLong.setAvgRating(4.6f);
        traOoLong.setQuantity(100);
        traOoLong.setStatus(true);
        traOoLong.setHotFlag(true);
        //traOoLong.setCategory(tea);
        tea.addProduct(traOoLong);

        Product traSen = new Product();
        traSen.setCode("Tra-Sen-Hao-Hang");
        traSen.setName("Trà Sen Hồ Tây");
        traSen.setUrlPath("/tra-sen");
        traSen.setDescription("Trà Sen được làm từ những ngọn chè xanh từ cùng cao nguyên Thái Lan ở tỉnh ChiangMai giúp loại bỏ gốc oxy tự do.");
        traSen.setPrice(BigDecimal.valueOf(98000L));
        traSen.setAvgRating(4.6f);
        traSen.setQuantity(100);
        traSen.setStatus(true);
        traSen.setHotFlag(true);
        //traSen.setCategory(tea);
        tea.addProduct(traSen);

        //============milk======================
        Product suaTuoiVinaMilkCoDuong = new Product();
        suaTuoiVinaMilkCoDuong.setCode("Sua-Tuoi-VinaMilk-Co-Duong");
        suaTuoiVinaMilkCoDuong.setName("Sữa tươi Vinamilk Có Đường");
        suaTuoiVinaMilkCoDuong.setUrlPath("/Sua-Tuoi-VinaMilk-Co-Duong");
        suaTuoiVinaMilkCoDuong.setDescription("Sữa tươi Vinamilk có đường dành cho người thích ngọt");
        suaTuoiVinaMilkCoDuong.setPrice(BigDecimal.valueOf(32000L));
        suaTuoiVinaMilkCoDuong.setAvgRating(4.6f);
        suaTuoiVinaMilkCoDuong.setQuantity(100);
        suaTuoiVinaMilkCoDuong.setStatus(true);
        suaTuoiVinaMilkCoDuong.setHotFlag(false);
        //suaTuoiVinaMilkCoDuong.setCategory(milk);
        milk.addProduct(suaTuoiVinaMilkCoDuong);

        Product suaTuoiVinaMilkItDuong = new Product();
        suaTuoiVinaMilkItDuong.setCode("Sua-Tuoi-VinaMilk-It-Duong");
        suaTuoiVinaMilkItDuong.setName("Sữa tươi Vinamilk Ít Đường");
        suaTuoiVinaMilkItDuong.setUrlPath("/Sua-Tuoi-VinaMilk-It-Duong");
        suaTuoiVinaMilkItDuong.setDescription("Sữa tươi Vinamilk ít đường dành cho người hơi thích ngọt");
        suaTuoiVinaMilkItDuong.setPrice(BigDecimal.valueOf(32000L));
        suaTuoiVinaMilkItDuong.setAvgRating(4.6f);
        suaTuoiVinaMilkItDuong.setQuantity(100);
        suaTuoiVinaMilkItDuong.setStatus(true);
        suaTuoiVinaMilkItDuong.setHotFlag(false);
        //suaTuoiVinaMilkItDuong.setCategory(milk);
        milk.addProduct(suaTuoiVinaMilkItDuong);

        Product suaTuoiVinaMilkKhongDuong = new Product();
        suaTuoiVinaMilkKhongDuong.setCode("Sua-Tuoi-VinaMilk-Khong-Duong");
        suaTuoiVinaMilkKhongDuong.setName("Sữa tươi Vinamilk Không Đường");
        suaTuoiVinaMilkKhongDuong.setUrlPath("/Sua-Tuoi-VinaMilk-Khong-Duong");
        suaTuoiVinaMilkKhongDuong.setDescription("Sữa tươi Vinamilk không đường dành cho người không thích ngọt");
        suaTuoiVinaMilkKhongDuong.setPrice(BigDecimal.valueOf(32000L));
        suaTuoiVinaMilkKhongDuong.setAvgRating(4.6f);
        suaTuoiVinaMilkKhongDuong.setQuantity(100);
        suaTuoiVinaMilkKhongDuong.setStatus(true);
        suaTuoiVinaMilkKhongDuong.setHotFlag(false);
        //suaTuoiVinaMilkKhongDuong.setCategory(milk);
        milk.addProduct(suaTuoiVinaMilkKhongDuong);

        Product suaChuaTHTrueMilk = new Product();
        suaChuaTHTrueMilk.setCode("Sua-Chua-TH-True-Milk");
        suaChuaTHTrueMilk.setName("Sữa Chua TH True Milk");
        suaChuaTHTrueMilk.setUrlPath("/Sua-Chua-TH-True-Milk");
        suaChuaTHTrueMilk.setDescription("Sữa chua TH True Milk được làm từ sữa tươi và vi khuẩn có lợi cho tiêu hoá.");
        suaChuaTHTrueMilk.setPrice(BigDecimal.valueOf(23000L));
        suaChuaTHTrueMilk.setAvgRating(4.6f);
        suaChuaTHTrueMilk.setQuantity(100);
        suaChuaTHTrueMilk.setStatus(true);
        suaChuaTHTrueMilk.setHotFlag(false);
        //suaChuaTHTrueMilk.setCategory(milk);
        milk.addProduct(suaChuaTHTrueMilk);
        //=======MilkTea==================
        Product trSuaAlisan = new Product();
        trSuaAlisan.setCode("Tra-Sua-Alisan");
        trSuaAlisan.setName("Trà Sữa Alisan");
        trSuaAlisan.setUrlPath("/Tra-Sua-Alisan");
        trSuaAlisan.setDescription("Trà sữa Alisan với vị ngọt dịu giúp bạn có một ngày làm việc thoải mái.");
        trSuaAlisan.setPrice(BigDecimal.valueOf(23000L));
        trSuaAlisan.setAvgRating(4.6f);
        trSuaAlisan.setQuantity(180);
        trSuaAlisan.setStatus(true);
        trSuaAlisan.setHotFlag(false);
        //trSuaAlisan.setCategory(milkTea);
        milkTea.addProduct(trSuaAlisan);

        Product traSuaHokaido = new Product();
        traSuaHokaido.setCode("Tra-Sua-Hokaido");
        traSuaHokaido.setName("Trà Sữa Hokaido");
        traSuaHokaido.setUrlPath("/Tra-Sua-Hokaido");
        traSuaHokaido.setDescription("Trà sữa Hokaido với vị ngọt dịu giúp bạn có một ngày làm việc thoải mái.");
        traSuaHokaido.setPrice(BigDecimal.valueOf(46000L));
        traSuaHokaido.setAvgRating(4.4f);
        traSuaHokaido.setQuantity(160);
        traSuaHokaido.setStatus(true);
        traSuaHokaido.setHotFlag(false);
        //traSuaHokaido.setCategory(milkTea);
        milkTea.addProduct(traSuaHokaido);


        Product trasuaKhoaiMon = new Product();
        trasuaKhoaiMon.setCode("Tra-Sua-Khoa-Mon");
        trasuaKhoaiMon.setName("Trà Sữa Khoai Môn");
        trasuaKhoaiMon.setUrlPath("/Tra-Sua-Khoa-Mon");
        trasuaKhoaiMon.setDescription("Trà sữa Khoai môn với vị ngọt dịu giúp bạn có một ngày làm việc thoải mái.");
        trasuaKhoaiMon.setPrice(BigDecimal.valueOf(40000L));
        trasuaKhoaiMon.setAvgRating(4.3f);
        trasuaKhoaiMon.setQuantity(108);
        trasuaKhoaiMon.setStatus(true);
        trasuaKhoaiMon.setHotFlag(false);
        //trasuaKhoaiMon.setCategory(milkTea);
        milkTea.addProduct(trasuaKhoaiMon);

        Product trasuaThai = new Product();
        trasuaThai.setCode("Tra-Sua-Thai");
        trasuaThai.setName("Trà Sữa Thái");
        trasuaThai.setUrlPath("/Tra-Sua-Thai");
        trasuaThai.setDescription("Trà sữa Thái với vị ngọt dịu giúp bạn có một ngày làm việc thoải mái.");
        trasuaThai.setPrice(BigDecimal.valueOf(40000L));
        trasuaThai.setAvgRating(4.5f);
        trasuaThai.setQuantity(182);
        trasuaThai.setStatus(true);
        trasuaThai.setHotFlag(false);
        //trasuaThai.setCategory(milkTea);
        milkTea.addProduct(trasuaThai);

        Product trasuaChocolate = new Product();
        trasuaChocolate.setCode("Tra-Sua-Chocolate");
        trasuaChocolate.setName("Trà Sữa Chocolate");
        trasuaChocolate.setUrlPath("/Tra-Sua-Chocolate");
        trasuaChocolate.setDescription("Trà sữa Chocolate với vị ngọt dịu giúp bạn có một ngày làm việc thoải mái.");
        trasuaChocolate.setPrice(BigDecimal.valueOf(50000L));
        trasuaChocolate.setAvgRating(4.5f);
        trasuaChocolate.setQuantity(182);
        trasuaChocolate.setStatus(true);
        trasuaChocolate.setHotFlag(false);
        //trasuaChocolate.setCategory(milkTea);
        milkTea.addProduct(trasuaChocolate);


        Product trasuaBuoi = new Product();
        trasuaBuoi.setCode("Tra-Sua-Buoi");
        trasuaBuoi.setName("Trà Sữa Bưởi");
        trasuaBuoi.setUrlPath("/Tra-Sua-Buoi");
        trasuaBuoi.setDescription("Trà sữa Bưởi với vị ngọt dịu giúp bạn có một ngày làm việc thoải mái.");
        trasuaBuoi.setPrice(BigDecimal.valueOf(50000L));
        trasuaBuoi.setAvgRating(4.5f);
        trasuaBuoi.setQuantity(182);
        trasuaBuoi.setStatus(true);
        trasuaBuoi.setHotFlag(false);
        //trasuaBuoi.setCategory(milkTea);
        milkTea.addProduct(trasuaBuoi);


        //=====Coffee======
        Product cfDenNong = new Product();
        cfDenNong.setCode("Ca-Phe-Den");
        cfDenNong.setName("Cà phê đen");
        cfDenNong.setUrlPath("/ca-phe-den");
        cfDenNong.setDescription("Cà phê đen không đường giúp bạn có một ngày làm việc thoải mái.");
        cfDenNong.setPrice(BigDecimal.valueOf(15000L));
        cfDenNong.setAvgRating(4.0f);
        cfDenNong.setQuantity(32);
        cfDenNong.setStatus(true);
        cfDenNong.setHotFlag(false);
        //cfDenNong.setCategory(coffee);
        coffee.addProduct(cfDenNong);

        Product cfDenNau = new Product();
        cfDenNau.setCode("Ca-Phe-Sua-Da");
        cfDenNau.setName("Cà phê sữa đá");
        cfDenNau.setUrlPath("/ca-phe-sua-da");
        cfDenNau.setDescription("Cà phê sữa đá giúp bạn có một ngày làm việc thoải mái.");
        cfDenNau.setPrice(BigDecimal.valueOf(17000L));
        cfDenNau.setAvgRating(4.8f);
        cfDenNau.setQuantity(72);
        cfDenNau.setStatus(true);
        cfDenNau.setHotFlag(false);
        //cfDenNau.setCategory(coffee);
        coffee.addProduct(cfDenNau);




//        categoryRepository.save(tea);
//        categoryRepository.save(milk);
//        categoryRepository.save(milkTea);
//        categoryRepository.save(coffee);
        categoryRepository.save(drink);


    }
}
