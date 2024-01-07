use atbm_proj;
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
                             `idcategory` int NOT NULL AUTO_INCREMENT,
                             `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `content` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `codecate` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`idcategory`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

INSERT INTO `category` VALUES ('1', 'Váy dạ hội', 'Váy dạ hội sang trọng', 'da-hoi');
INSERT INTO `category` VALUES ('2', 'Đầm váy', 'Váy đầm với nhiều kiểu dáng đặc sắc', 'dam-vay');
INSERT INTO `category` VALUES ('3', 'Vest', 'Các loại vest trending nhất 2022', 'vest');
INSERT INTO `category` VALUES ('4', 'Chân váy', 'Chân váy công sở với nhiều kiểu dáng', 'chan-vay');
INSERT INTO `category` VALUES ('5', 'Quần', 'Quần trending 2022, được ưa chuộng nhất', 'quan');
INSERT INTO `category` VALUES ('6', 'Set đồ', 'Các set đồ được G15 đề cử trong 2022', 'set-do');
INSERT INTO `category` VALUES ('7', 'Áo khoác', 'Các mẫu áo khoác từ G15, phù hợp với mọi loại', 'ao-khoac');
INSERT INTO `category` VALUES ('8', 'Áo dài', 'Các mẫu áo dài, áo dài cách tân', 'ao-dai');

DROP TABLE IF EXISTS `color`;
CREATE TABLE `color`  (
                          `idcolor` int NOT NULL AUTO_INCREMENT,
                          `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                          `codecolor` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                          PRIMARY KEY (`idcolor`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of color
-- ----------------------------
INSERT INTO `color` VALUES ('1', 'Đen', 'black');
INSERT INTO `color` VALUES ('2', 'Trắng', 'white');
INSERT INTO `color` VALUES ('3', 'Nâu', 'brown');
INSERT INTO `color` VALUES ('4', 'Đỏ', 'red');
INSERT INTO `color` VALUES ('5', 'Xanh dương', 'blue');
INSERT INTO `color` VALUES ('6', 'Xanh pastel', 'lightblue');
INSERT INTO `color` VALUES ('7', 'Xanh lá', 'green');
INSERT INTO `color` VALUES ('8', 'Vàng', 'yellow');
INSERT INTO `color` VALUES ('9', 'Hồng pastel', 'lightpink');
INSERT INTO `color` VALUES ('10', 'Tím pastel', 'plum');
INSERT INTO `color` VALUES ('11', 'Tím đỏ', 'palevioletred');
INSERT INTO `color` VALUES ('12', 'Xám', 'grey');
INSERT INTO `color` VALUES ('13', 'Be', 'beige');
INSERT INTO `color` VALUES ('14', 'Nhiều màu', '0');

DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
                             `idmaterial` int NOT NULL AUTO_INCREMENT,
                             `title` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `codematerial` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`idmaterial`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES ('1', 'Cotton', 'Vào mùa hè, vải cotton luôn là lựa chọn số 1 bởi chúng có độ thoáng khí rất cao. Váy đầm cotton lên phom dáng cũng khá chuẩn và sử dụng được nhiều trong hoàn cảnh khác nhau.', 'cotton');
INSERT INTO `material` VALUES ('2', 'Nhung', 'Vải nhung là chất liệu mịn và rất sang nhưng ít khi được sử dụng vào mùa hè. Bởi chất liệu nhung có khả năng giữ nhiệt cao hơn các loại vải khác. Tuy vậy vải nhung vẫn là chất liệu được chị em ưa chuộng bởi chúng đem đến một vẻ đẹp quyến rũ và đầy bí ẩn.', 'nhung');
INSERT INTO `material` VALUES ('3', 'Chiffon', 'Mỏng, nhẹ, bay bổng chính là những đặc điểm đặc trưng của vải chiffon. Cũng chính vì lý do này mà mọi người rất thích chọn vải chiffon để may váy đầm. Váy đầm chiffon giúp người mặc trở nên nhẹ nhàng, quyến rũ và nữ tính hơn rất nhiều.', 'chiffon');
INSERT INTO `material` VALUES ('4', 'Lụa', 'Vải lụa cũng được nhiều bạn gái chọn để may váy đầm, với độ bóng và sự mềm mại của lụa, chiếc váy đầm trở nên hoàn hảo hơn bao giờ hết. Không những thế vải lụa còn đem đến sự sang trọng và quý phái cho người mặc.', 'lua');
INSERT INTO `material` VALUES ('5', 'Tafta', 'Là loại vải được dệt theo công nghệ dệt xoắn, có nguồn gốc từ nhiều nguyên liệu khác nhau như lụa, sợi bông và một số nguyên liệu tổng hợp khác. Bề mặt vải tafta có ánh kim và khả năng bắt ánh sáng tốt nên rất được chị em tin dùng để may váy đầm.', 'tafta');
INSERT INTO `material` VALUES ('6', 'Đũi', 'Mặc dù không được mềm mại như vải lụa, nhưng vải đũi vẫn có độ rũ và vay đầm vẫn có độ bồng bềnh nhẹ. Vải đũi cũng được sử dụng để may nhiều kiểu váy khác nhau phù hợp theo từng môi trường và hoạt động', 'dui');
INSERT INTO `material` VALUES ('7', 'Ren', 'Vải ren là hơi thở của chị em phụ nữ chúng mình, với cách dệt độc đáo cùng với những chi tiết hoa văn trên bề mặt, vải ren được mọi người ưa chuộng khi may các loại váy đầm phục vụ cho từng nhu cầu của bản thân.', 'ren');
INSERT INTO `material` VALUES ('8', 'Organza', 'Vải organza mềm và mỏng nhưng lại tạo nên sự nhẹ nhàng và tinh khiết khi may váy đầm. Các đặc tính của chất liệu khiến chị em mê mệt khi có thể dễ dàng trở thành những cô gái thuỳ mị, nữ tính trong chốc lát với chiếc váy đầm trên tay.', 'organza');
INSERT INTO `material` VALUES ('9', 'Da', 'Loại da tổng hợp an toàn với cơ thể, có chứng nhận của y tế', 'da');
INSERT INTO `material` VALUES ('10', 'Kaki', 'Phù hợp với các kiểu áo khoác và các sản phẩm đứng, chấy dày dặn', 'kaki');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
                            `idproduct` int NOT NULL AUTO_INCREMENT,
                            `idcategory` int NULL DEFAULT NULL,
                            `idmaterial` int NULL DEFAULT NULL,
                            `idcolor` int NULL DEFAULT NULL,
                            `sku` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                            `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                            `image` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                            `price` float NULL DEFAULT 0,
                            `discount` float NULL DEFAULT 0,
                            `quantity` int NULL DEFAULT 20,
                            `status` int NULL DEFAULT 0,
                            `mode` int NULL DEFAULT 0,
                            `startAt` datetime NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                            `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`idproduct`) USING BTREE,
                            INDEX `idcategory`(`idcategory` ASC) USING BTREE,
                            INDEX `idmaterial`(`idmaterial` ASC) USING BTREE,
                            INDEX `idcolor`(`idcolor` ASC) USING BTREE,
                            CONSTRAINT `product_ibfk_1` FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `product_ibfk_2` FOREIGN KEY (`idmaterial`) REFERENCES `material` (`idmaterial`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `product_ibfk_3` FOREIGN KEY (`idcolor`) REFERENCES `color` (`idcolor`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 120 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
select * from product;
-- ----------------------------
-- Lệnh 1
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 4, 2, 'DH03', 'Váy đuôi cá trắng phối lông vũ ', 'DH (3).jpg', 22200000, 21990000, 5, 0, 1, '2022-12-25 16:21:12', 'Váy đuôi cá trắng phối lông vũ ');

-- Lệnh 2
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 5, 2, 'DH04', 'Váy dạ hội dự tiệc sang trọng màu trắng, xẻ tà', 'DH (4).jpg', 18999000, 0, 5, 0, 1, '2022-12-25 16:23:38', 'Váy dạ hội dự tiệc sang trọng màu trắng, xẻ t');

-- Lệnh 3
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 5, 2, 'DH05', 'Váy dạ hội dự tiệc sang trọng màu trắng dáng suông', 'DH (5).jpg', 15550000, 14999000, 5, 0, 0, '2022-12-25 16:26:26', 'Váy đuôi cá lấp lánh tông xanh lá ');

-- Lệnh 4
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 7, 7, 'DH06', 'Váy đuôi cá lấp lánh tông xanh lá ', 'DH (6).jpg', 16660000, 0, 5, 0, 1, '2022-12-25 16:28:16', 'Váy đuôi cá lấp lánh tông xanh lá ');

-- Lệnh 5
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 8, 2, 'DH07', 'Váy trễ vai sang trọng kết hợp với lông vũ ', 'DH (7).jpg', 22200000, 21990000, 2, 0, 1, '2022-12-25 22:46:13', 'Váy trễ vai sang trọng kết hợp với lông vũ ');
-- Lệnh 6
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 4, 4, 'DH08', 'Váy dáng suông dài tông đỏ lệch vai tay dài', 'DH (8).jpg', 12000000, 0, 3, 0, 0, '2022-12-25 16:30:25', 'Váy dáng suông dài tông đỏ lệch vai tay dài');

-- Lệnh 7
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 8, 5, 'DH09', 'Váy suông cổ yếm hở vai lấp lánh', 'DH (9).jpg', 25200000, 24999000, 3, 0, 0, '2022-12-25 23:15:54', 'Váy suông cổ yếm hở vai lấp lánh');

-- Lệnh 8
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 4, 6, 'DH10', 'Váy xẻ tà trễ vai tông xanh lấp lánh', 'DH (10).jpg', 11000000, 0, 10, 0, 0, '2022-12-25 23:15:58', 'Váy xẻ tà trễ vai tông xanh lấp lánh');

-- Lệnh 9
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 5, 1, 'DH11', 'Váy đuôi cá kết hợp với áo tay dài đen cổ trắng', 'DH (11).jpg', 9999000, 8888000, 10, 0, 1, '2022-12-25 23:16:01', 'Váy đuôi cá kết hợp với áo tay dài đen cổ trắng');

-- Lệnh 10
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 4, 2, 'DH12', 'Váy dài trắng xẻ tà trễ vai một bên ', 'DH (12).jpg', 18999000, 0, 5, 0, 0, '2022-12-25 23:16:04', 'Váy dài trắng xẻ tà trễ vai một bên ');

-- Lệnh 11
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 8, 5, 'DH13', 'Váy đuôi cá tông lam thiết kế nơ to một bên vai', 'DH (13).jpg', 19999000, 18999000, 5, 0, 1, '2022-12-25 23:16:08', 'Váy đuôi cá tông lam thiết kế nơ to một bên vai');

-- Lệnh 12
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 2, 1, 'DH14', 'Váy body tông đen sang trọng hai dây ', 'DH (14).jpg', 9999000, 8888000, 10, 0, 0, '2022-12-25 23:16:12', 'Váy body tông đen sang trọng hai dây ');

-- Lệnh 13
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 8, 6, 'DH15', 'Váy xoè tông xám lấp lánh xẻ tà  ', 'DH (15).jpg', 22200000, 21990000, 3, 0, 0, '2022-12-25 23:16:15', 'Váy xoè tông xám lấp lánh xẻ tà  ');

-- Lệnh 14
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 8, 2, 'DH16', 'Váy dáng công chúa tông trắng lấp lánh', 'DH (16).jpg', 23200000, 0, 5, 0, 1, '2022-12-25 23:16:19', 'Váy dáng công chúa tông trắng lấp lánh');

-- Lệnh 15
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (1, 8, 8, 'DH17', 'Váy xoè tông vàng xẻ tà  ', 'DH (17).jpg', 25200000, 0, 2, 0, 0, '2022-12-25 23:16:23', 'Váy xoè tông vàng xẻ tà  ');

-- Lệnh 16
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 6, 2, 'DV16', 'Đầm trắng xoè phần bèo ở vai', 'DV (16).jpg', 3999000, 3333000, 5, 0, 0, '2022-12-26 22:00:06', 'Đầm trắng xoè phần bèo ở vai');

-- Lệnh 17
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 5, 2, 'DV17', 'Đầm trắng suông trễ vai', 'DV (17).jpg', 7500000, 0, 20, 0, 0, '2022-12-26 22:00:11', 'Đầm trắng suông trễ vai');

-- Lệnh 18
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 6, 'DV18', 'Đầm lam nhạt cổ tròn có nơ ở eo', 'DV (18).jpg', 3999000, 0, 15, 0, 0, '2022-12-26 22:00:15', 'Đầm lam nhạt cổ tròn có nơ ở eo');

-- Lệnh 19
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 6, 'DV19', 'Đấm lam nhạt tay dài xẻ ngực xẻ tà', 'DV (19).jpg', 4999000, 3999000, 5, 0, 0, '2022-12-26 22:00:19', 'Đấm lam nhạt tay dài xẻ ngực xẻ tà');

-- Lệnh 20
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 9, 'DV20', 'Đầm chữ A trắng hồng tay dài', 'DV (20).jpg', 4999000, 0, 5, 0, 1, '2022-12-26 22:00:23', 'Đầm chữ A trắng hồng tay dài');

-- Lệnh 21
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 9, 'DV21', 'Đầm hồng xoè bồng bềnh ở phần vai', 'DV (21).jpg', 4999000, 0, 15, 0, 1, '2022-12-26 22:00:26', 'Đầm hồng xoè bồng bềnh ở phần vai');

-- Lệnh 22
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 9, 'DV22', 'Váy chữ A nhiều màu sắc kết hợp với áo sơ mi kiểu bồng bềnh hồng', 'DV (22).jpg', 5999000, 0, 5, 0, 0, '2022-12-26 22:00:30', 'Váy chữ A nhiều màu sắc kết hợp với áo sơ mi kiểu bồng bềnh hồng');

-- Lệnh 23
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 4, 6, 'DV23', 'Đầm trắng xanh ôm eo tay dài', 'DV (23).jpg', 5999000, 0, 5, 0, 0, '2022-12-26 22:00:36', 'Đầm trắng xanh ôm eo tay dài');

-- Lệnh 24
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 4, 9, 'DV24', 'Đầm hồng suông kết hợp với áo khoác kiểu hồng', 'DV (24).jpg', 5999000, 0, 5, 0, 1, '2022-12-26 22:00:39', 'Đầm hồng suông kết hợp với áo khoác kiểu hồng');

-- Lệnh 25
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 5, 9, 'DV25', 'Váy hồng suông kết hợp áo sơ mi hồng', 'DV (25).jpg', 4999000, 4889000, 5, 0, 0, '2022-12-26 22:00:43', 'Váy hồng suông kết hợp áo sơ mi hồng');

-- Lệnh 26
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 9, 'DV26', 'Váy nhiều màu sắc suông cúp ngực', 'DV (26).jpg', 3999000, 0, 5, 0, 0, '2022-12-26 22:00:53', 'Váy nhiều màu sắc suông cúp ngực');

-- Lệnh 27
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 6, 2, 'DV27', 'Đầm trắng cúp ngực ôm sát', 'DV (27).jpg', 3999000, 0, 5, 0, 0, '2022-12-26 22:00:58', 'Đầm trắng cúp ngực ôm sát');

-- Lệnh 28
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 9, 'DV28', 'Đầm trắng hồng chữ A xẻ ngực tay bồng', 'DV (28).jpg', 4999000, 0, 5, 0, 0, '2022-12-26 22:01:03', 'Đầm trắng hồng chữ A xẻ ngực tay bồng');

-- Lệnh 29
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 4, 2, 'DV29', 'Đầm trắng suông cổ vuông tay bồng', 'DV (29).jpg', 3999000, 3799000, 50, 0, 1, '2022-12-26 22:01:08', 'Đầm trắng suông cổ vuông tay bồng');

-- Lệnh 30
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (2, 1, 6, 'DV30', 'Đầm trắng xanh ôm dáng tay ngắn', 'DV (30).jpg', 7500000, 5999000, 5, 0, 0, '2022-12-26 22:01:12', 'Đầm trắng xanh ôm dáng tay ngắn');

-- Lệnh 31
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 1, 12, 'V01', 'Vest xám có điểm nhấn bông hoa trên vai', 'vestt(1).jpg', 2999000, 0, 15, 0, 1, '2022-12-26 22:05:53', 'Vest xám có điểm nhấn bông hoa trên vai');

-- Lệnh 32
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 1, 3, 'V02', 'Vest nâu có điểm nhấn bông hoa trên ngực', 'vestt(2).jpg', 2999000, 0, 15, 0, 0, '2022-12-26 22:07:04', 'Vest nâu có điểm nhấn bông hoa trên ngực');

-- Lệnh 33
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 1, 2, 'V03', 'Vest trắng đơn giản', 'vestt(3).jpg', 1999000, 999000, 15, 0, 1, '2022-12-26 22:08:17', 'Vest trắng đơn giản');

-- Lệnh 34
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 6, 3, 'V04', 'Vest nâu đơn giản', 'vestt(4).jpg', 1999000, 0, 55, 0, 0, '2022-12-26 22:09:39', 'Vest nâu đơn giản');

-- Lệnh 35
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 6, 1, 'V05', 'Vest đen cực tôn dáng', 'vestt(5).jpg', 2500000, 0, 55, 0, 1, '2022-12-26 22:10:50', 'Vest đen cực tôn dáng');

-- Lệnh 36
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 4, 7, 'V06', 'Vest xanh lá đơn giản có điểm nhấn trắng ở phần cổ', 'vestt(6).jpg', 2500000, 0, 15, 0, 0, '2022-12-26 22:11:57', 'Vest xanh lá đơn giản có điểm nhấn trắng ở phần cổ');

-- Lệnh 37
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 5, 2, 'V07', 'Vest pha trộn giữa màu trắng đen cực sang trọng', 'vestt(7).jpg', 2999000, 0, 5, 0, 0, '2022-12-26 22:13:53', 'Vest pha trộn giữa màu trắng đen cực sang trọng');

-- Lệnh 38
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 4, 1, 'V08', 'Vest đen có phần bèo ở tay', 'vestt(8).jpg', 2999000, 1999000, 5, 0, 0, '2022-12-26 22:14:17', 'Vest đen có phần bèo ở tay');

-- Lệnh 39
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 1, 2, 'V09', 'Vest trắng có điểm nhấn bông hoa ở ngực', 'vestt(9).jpg', 1999000, 0, 5, 0, 1, '2022-12-26 22:15:23', 'Vest trắng có điểm nhấn bông hoa ở ngực');

-- Lệnh 40
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (3, 5, 9, 'V10', 'Vest hồng nhạt tay ngắn', 'vestt(10).jpg', 1999000, 0, 5, 0, 0, '2022-12-26 22:16:34', 'Vest hồng nhạt tay ngắn');

-- Lệnh 41
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 1, 2, 'CV01', 'Chân váy trắng suông lửng đơn giản', 'CV (1).jpg', 499000, 399000, 25, 0, 0, '2022-12-26 22:54:28', 'Chân váy trắng suông lửng đơn giản');

-- Lệnh 42
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 6, 3, 'CV02', 'Chân váy ôm lửng đơn giản', 'CV (2).jpg', 399000, 0, 25, 0, 0, '2022-12-26 22:54:31', 'Chân váy ôm lửng đơn giản');

-- Lệnh 43
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 1, 2, 'CV03', 'Chân váy trắng lửng xẻ tà', 'CV (3).jpg', 399000, 0, 5, 0, 0, '2022-12-26 22:55:37', 'Chân váy trắng lửng xẻ tà');

-- Lệnh 44
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 5, 13, 'CV04', 'Chân váy be suông lửng đơn giản', 'CV (4).jpg', 299000, 250000, 50, 0, 1, '2022-12-27 00:20:02', 'Chân váy trắng suông lửng đơn giản');

-- Lệnh 45
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 5, 12, 'CV05', 'Chân váy xám xếp ly lửng', 'CV (5).jpg', 299000, 0, 50, 0, 0, '2022-12-27 00:05:54', 'Chân váy xám xếp ly lửng');

-- Lệnh 46
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 3, 1, 'CV06', 'Chân váy đen xếp ly lửng', 'CV (6).jpg', 399000, 0, 15, 0, 0, '2022-12-27 00:07:46', 'Chân váy đen xếp ly lửng');

-- Lệnh 47
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 6, 1, 'CV07', 'Chân váy sọc ca rô nhỏ ôm sát đơn giản', 'CV (7).jpg', 299000, 0, 55, 0, 0, '2022-12-27 00:07:54', 'Chân váy sọc ca rô nhỏ ôm sát đơn giản');

-- Lệnh 48
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 9, 1, 'CV08', 'Chân váy đen da suông đơn giản', 'CV (8).jpg', 599000, 499000, 20, 0, 0, '2022-12-27 00:11:15', 'Chân váy đen da suông đơn giản');

-- Lệnh 49
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (4, 9, 1, 'CV09', 'Chân váy đen da xoè đơn giản', 'CV (9).jpg', 699000, 0, 20, 0, 1, '2022-12-27 00:12:08', 'Chân váy đen da xoè đơn giản');

-- Lệnh 50
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 1, 3, 'Q01', 'Quần tây nâu', 'quann(1).jpg', 550000, 0, 100, 0, 0, '2022-12-27 00:16:44', 'Quần tây nâu');

-- Lệnh 51
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 5, 1, 'Q02', 'Quần loe đen có túi hộp ở trước', 'quann(2).jpg', 250000, 0, 100, 0, 0, '2022-12-27 00:16:46', 'Quần loe đen có túi hộp ở trước');

-- Lệnh 52
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 1, 3, 'Q03', 'Quần thụng nâu', 'quann(3).jpg', 350000, 0, 100, 0, 1, '2022-12-27 00:16:52', 'Quần thụng nâu');

-- Lệnh 53
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 6, 2, 'Q04', 'Quần tây trắng', 'quann(4).jpg', 250000, 0, 100, 0, 0, '2022-12-27 00:17:45', 'Quần tây trắng');

-- Lệnh 54
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 5, 13, 'Q05', 'Quần tây be', 'quann(5).jpg', 250000, 0, 100, 0, 0, '2022-12-27 00:20:38', 'Quần tây be');

-- Lệnh 55
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 5, 1, 'Q06', 'Quần loe đen', 'quann(6).jpg', 350000, 0, 100, 0, 1, '2022-12-27 00:21:46', 'Quần loe đen');

-- Lệnh 56
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 5, 5, 'Q07', 'Quần thụng lam', 'quann(7).jpg', 350000, 250000, 100, 0, 0, '2022-12-27 00:23:31', 'Quần thụng lam');

-- Lệnh 57
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 1, 13, 'Q08', 'Quần tây be đậm', 'quann(8).jpg', 350000, 0, 100, 0, 0, '2022-12-27 00:24:54', 'Quần tây be đậm');

-- Lệnh 58
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (5, 5, 1, 'Q09', 'Quần thụng đen có bèo ở chân quần', 'quann(9).jpg', 550000, 0, 100, 0, 0, '2022-12-27 00:25:43', 'Quần thụng đen có bèo ở chân quần');

-- Lệnh 59
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 3, 2, 'SD01', 'Set đồ quần hồng ngắn kết hợp với áo trắng tay dài bèo', 'setdo(1).jpg', 1290000, 0, 20, 0, 1, '2022-12-27 01:15:06', 'Set đồ quần hồng ngắn kết hợp với áo trắng tay dài bèo');

-- Lệnh 60
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 5, 2, 'SD02', 'Set đồ trắng váy chữ A kết hợp áo sơ mi có áo khoác dài ở ngoài', 'setdo(2).jpg', 3390000, 0, 20, 0, 0, '2022-12-27 01:15:07', 'Set đồ trắng váy chữ A kết hợp áo sơ mi có áo khoác dài ở ngoài');

-- Lệnh 61
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 4, 14, 'SD03', 'Set đồ hoa nhiều màu sắc váy chữ A kết hợp với áo tay dài có nơ cổ', 'setdo(3).jpg', 4490000, 0, 20, 0, 0, '2022-12-27 01:15:08', 'Set đồ hoa nhiều màu sắc váy chữ A kết hợp với áo tay dài có nơ cổ');

-- Lệnh 62
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 4, 10, 'SD04', 'Set đồ lông vũ ở cuối phần váy chữ A tay áo dài bên trong có áo bó sát', 'setdo(4).jpg', 4490000, 0, 20, 0, 1, '2022-12-27 01:15:09', 'Set đồ lông vũ ở cuối phần váy chữ A tay áo dài bên trong có áo bó sát');

-- Lệnh 63
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 3, 9, 'SD05', 'Set đồ hồng chân váy chữ A kết hợp với áo tay dài có nơ cổ', 'setdo(5).jpg', 3490000, 0, 20, 0, 0, '2022-12-27 01:15:10', 'Set đồ hồng chân váy chữ A kết hợp với áo tay dài có nơ cổ');

-- Lệnh 64
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 2, 7, 'SD06', 'Set đồ xanh lá chân váy chữ A kết hợp áo tay dài có nơ cổ trắng', 'setdo(6).jpg', 3490000, 0, 20, 0, 0, '2022-12-27 01:25:04', 'Set đồ xanh lá chân váy chữ A kết hợp áo tay dài có nơ cổ trắng');

-- Lệnh 65
INSERT INTO `product` (`idcategory`, `idmaterial`, `idcolor`, `sku`, `title`, `image`, `price`, `discount`, `quantity`, `status`, `mode`, `startAt`, `content`)
VALUES (6, 6, 5, 'SD07', 'Set đồ lam chân váy chữ A kết hợp áo tay dài có nơ ở ngực', 'setdo(7).jpg', 4490000, 0, 20, 0, 0, '2022-12-27 01:25:07', 'Set đồ lam chân váy chữ A kết hợp áo tay dài có nơ ở ngực');


update product set status = 1 where idproduct > 0;
-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
                         `iduser` int NOT NULL AUTO_INCREMENT,
                         `lastname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `firstname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `email` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `phone` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `role` int NULL DEFAULT NULL,
                         `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                         `status` int NULL DEFAULT NULL,
                         PRIMARY KEY (`iduser`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Tran', 'Admin', 'htmynguyen@gmail.com', '0779068083', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', 2, 'admin', 1);
INSERT INTO `user` VALUES (2, 'Nguyen Thi Truc', 'Mai', 'trucmainguyen02@gmail.com', '0987654321', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', 1, 'mainguyen', 1);

SET FOREIGN_KEY_CHECKS = 1;
select * from user;

DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
                           `idaddress` int(11) NOT NULL AUTO_INCREMENT,
                           `iduser` int(11) NOT NULL,
                           `name` varchar(45) NOT NULL,
                           `phone` varchar(45) NOT NULL,
                           `address` varchar(45) NOT NULL,
                           `isdefault` int(11) NOT NULL,
                           `status` int(11) NOT NULL,
                           `content` varchar(45) NOT NULL,
                           PRIMARY KEY (`idaddress`),
                           KEY `fk_useridaddress` (`iduser`),
                           CONSTRAINT `fk_useridaddress` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;

select * from address;
INSERT INTO `address` VALUES (1, 2, 'Nguyễn Thị Trúc Mai', '0942559610', 'Tiền Giang', 1, 0, 'giao giờ hành chính');

DROP TABLE IF EXISTS `coupons`;
CREATE TABLE `coupons` (
                           `idcoupons` int(11) NOT NULL AUTO_INCREMENT,
                           `iduser` int(11) NOT NULL,
                           `code` varchar(45) NOT NULL,
                           `title` varchar(45) NOT NULL,
                           `price` float NOT NULL,
                           `status` int(11) NOT NULL,
                           `actice` int(11) DEFAULT NULL,
                           `content` varchar(45) NOT NULL,
                           PRIMARY KEY (`idcoupons`),
                           KEY `fk_useridcoupons` (`iduser`),
                           CONSTRAINT `fk_useridcoupons` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;

select * from coupons;
INSERT INTO `coupons` VALUES (1, 2, 'CODE01', 'Mặc định', 0, 1, 1, '');

DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
                          `idorders` int(11) NOT NULL AUTO_INCREMENT,
                          `iduser` int(11) DEFAULT NULL,
                          `idaddress` int(11) DEFAULT NULL,
                          `subtotal` float DEFAULT NULL,
                          `itemdiscount` float DEFAULT NULL,
                          `shipping` float DEFAULT NULL,
                          `idcoupons` int(11) DEFAULT NULL,
                          `grandtotal` float DEFAULT NULL,
                          `status` int(11) DEFAULT NULL,
                          `content` varchar(45) DEFAULT NULL,
                          PRIMARY KEY (`idorders`),
                          KEY `fk_couponsidorders` (`idcoupons`),
                          KEY `fk_useridorders` (`iduser`),
                          KEY `fk_addressidorders` (`idaddress`),
                          CONSTRAINT `fk_addressidorders` FOREIGN KEY (`idaddress`) REFERENCES `address` (`idaddress`) ON UPDATE CASCADE,
                          CONSTRAINT `fk_couponsidorders` FOREIGN KEY (`idcoupons`) REFERENCES `coupons` (`idcoupons`) ON UPDATE CASCADE,
                          CONSTRAINT `fk_useridorders` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;


select * from orders;

DROP TABLE IF EXISTS `orderdetail`;
CREATE TABLE `orderdetail` (
                               `idorderdetail` int(11) NOT NULL AUTO_INCREMENT,
                               `idorders` int(11) NOT NULL,
                               `idproduct` int(11) NOT NULL,
                               `quantity` int(11) NOT NULL,
                               `size` varchar(45) NOT NULL,
                               `price` float NOT NULL,
                               `discount` float NOT NULL,
                               `ismeasure` int(11) NOT NULL,
                               `weight` float NOT NULL,
                               `height` float NOT NULL,
                               `round1` float NOT NULL,
                               `round2` float NOT NULL,
                               `round3` float NOT NULL,
                               `content` varchar(45) NOT NULL,
                               PRIMARY KEY (`idorderdetail`),
                               KEY `fk_productidorderdetail` (`idproduct`),
                               KEY `fk_orderidorderdetail` (`idorders`),
                               CONSTRAINT `fk_orderidorderdetail` FOREIGN KEY (`idorders`) REFERENCES `orders` (`idorders`) ON UPDATE CASCADE,
                               CONSTRAINT `fk_productidorderdetail` FOREIGN KEY (`idproduct`) REFERENCES `product` (`idproduct`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;

select * from orderdetail;

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE `invoice` (
                           `idinvoice` int(11) NOT NULL AUTO_INCREMENT,
                           `idusers` int(11) NOT NULL,
                           `idorder` int(11) NOT NULL,
                           `status` int(11) NOT NULL,
                           `mode` int(11) NOT NULL,
                           `createAt` datetime NOT NULL DEFAULT current_timestamp(),
                           `content` varchar(45) NOT NULL,
                           PRIMARY KEY (`idinvoice`),
                           KEY `fk_orderidinvoice` (`idorder`),
                           KEY `fk_useridinvoice` (`idusers`),
                           CONSTRAINT `fk_orderidinvoice` FOREIGN KEY (`idorder`) REFERENCES `orders` (`idorders`) ON UPDATE CASCADE,
                           CONSTRAINT `fk_useridinvoice` FOREIGN KEY (`idusers`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE utf8mb4_general_ci;

select * from invoice;

CREATE TABLE role (
                      `idrole` INT NOT NULL AUTO_INCREMENT,
                      `rolename` VARCHAR(45) NULL,
                      `action` VARCHAR(45) NOT NULL,
                      `status` INT NOT NULL,
                      `createAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                      `updateAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                      PRIMARY KEY (`idrole`));


CREATE TABLE permission  (
                             `idpermission` INT NOT NULL AUTO_INCREMENT,
                             `permissionname` VARCHAR(45) NULL,-- Thêm sản phẩm
                             `action` VARCHAR(45) NOT NULL,-- client-- keyword AddProduct
                             `status` INT NOT NULL,
                             `createAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                             `updateAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                             PRIMARY KEY (`idpermission`));


CREATE TABLE role_permission (
                                 `idrole` INT NOT NULL,
                                 `idpermission` INT NOT NULL,
                                 `status` INT NOT NULL,
                                 `createAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                 `updateAt` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(),
                                 PRIMARY KEY (`idrole`, `idpermission`));


ALTER TABLE role_permission
    ADD CONSTRAINT `fk_idrole`
        FOREIGN KEY (`idrole`)
            REFERENCES `role` (`idrole`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;


ALTER TABLE role_permission
    ADD CONSTRAINT `fk_idpermission`
        FOREIGN KEY (`idpermission`)
            REFERENCES `permission` (`idpermission`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

ALTER TABLE user
    ADD COLUMN `idrole` INT NULL AFTER `status`;

ALTER TABLE user
    ADD CONSTRAINT `fk_idrole_user`
        FOREIGN KEY (`idrole`)
            REFERENCES `role` (`idrole`)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

select * from user where username = 'admin' and password = '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090' and status = 1;
-- có roleid
-- dánh sách vai trờ (role) và quyền (permission)
select rp.idrole, r.rolename, r.action, rp.idpermission,  p.permissionname, p.action
from role_permission rp
         join role r on rp.idrole = r.idrole
         join permission p on rp.idpermission = p.idpermission
where rp.idrole = 3;


/* Du lieu */

INSERT INTO role (`idrole`, `rolename`, `status`, `action`) VALUES (1,'Giám đốc', '1', 'giamdoc');
INSERT INTO role (`idrole`, `rolename`, `status`, `action`) VALUES (2,'Quản lí sản phẩm', '1', 'quanlisanpham');
INSERT INTO role (`idrole`, `rolename`, `status`, `action`) VALUES (3,'Quản lí đơn hàng', '1', 'quanlidonhang');
INSERT INTO role (`idrole`, `rolename`, `status`, `action`) VALUES (4,'Quản lí bình luận', '1', 'quanlibinhluan');

UPDATE user SET `idrole` = '1' WHERE (`iduser` = '1');
UPDATE user SET `role` = '2', `idrole` = '2' WHERE (`iduser` = '5');

INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (1, 'Danh sách sản phẩm', 'product.list', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (2, 'Thêm sản phẩm', 'product.add', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (3, 'Chỉnh sửa sản phẩm', 'product.edit', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (4, 'Xem chi tiết sản phẩm', 'product.detail', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (5, 'Xóa sản phẩm', 'product.delete', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (6, 'Danh sách đơn hàng', 'order.list', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (7, 'Cập nhật trạng thái đơn hàng', 'order.edit', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (8, 'Chi tiết đơn hàng', 'order.detail', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (9, 'Danh sách tài khoản', 'user.list', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (10, 'Thêm tài khoản', 'user.add', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (11, 'Chỉnh sửa tài khoản', 'user.edit', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (12, 'Xem chi tiết tài khoản', 'user.detail', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (13, 'Xóa tài khoản', 'user.delete', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (14, 'Phân quyền', 'permission.list', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (15, 'Thêm phân quyền', 'permission.add', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (16, 'Chỉnh sửa phân quyền', 'permission.edit', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (17, 'Xem chi tiết phân quyền', 'permission.detail', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (18, 'Xóa phân quyền', 'permission.delete', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (19, 'Role', 'role.list', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (20, 'Quản lí phân quyền', 'permission.crud.list', '1');
INSERT INTO permission (`idpermission`,`permissionname`, `action`, `status`) VALUES (21, 'Quản lí role', 'role.crud.list', '1');


INSERT INTO `atbm_proj`.`permission` (`idpermission`, `permissionname`, `action`, `status`) VALUES ('22', 'Quản lý bình luận', 'comments.list', '1');
INSERT INTO `atbm_proj`.`permission` (`idpermission`, `permissionname`, `action`, `status`) VALUES ('23', 'Quản lý giới thiệu', 'aboutus.list', '1');
INSERT INTO `atbm_proj`.`permission` (`idpermission`, `permissionname`, `action`, `status`) VALUES ('24', 'Quản lý tin tức', 'news.list', '1');


INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 1, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 2, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 3, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 4, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 5, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 6, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 7, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 8, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 9, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 10, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 11, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 12, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 13, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 14, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 15, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 16, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 17, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 18, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 19, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 20, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (1, 21, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (2, 1, 1);
INSERT INTO role_permission (`idrole`, `idpermission`, `status`) VALUES (2, 2, 0);
INSERT INTO `atbm_proj`.`role_permission` (`idrole`, `idpermission`, `status`) VALUES ('1', '22', '1');
INSERT INTO `atbm_proj`.`role_permission` (`idrole`, `idpermission`, `status`) VALUES ('1', '23', '1');
INSERT INTO `atbm_proj`.`role_permission` (`idrole`, `idpermission`, `status`) VALUES ('1', '24', '1');



CREATE TABLE `log` (
                       `idlog` int(11) NOT NULL AUTO_INCREMENT,
                       `iduser` int(11) DEFAULT NULL,
                       `username` varchar(45) DEFAULT NULL,
                       `ip` varchar(45) DEFAULT NULL,
                       `createAt` datetime DEFAULT current_timestamp(),
                       PRIMARY KEY (`idlog`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


/* fk_useridaddress
fk_useridcoupons
fk_useridinvoice
fk_useridorders */

CREATE TABLE `facebook` (
                            `idfacebook` varchar(45) NOT NULL,
                            `name` varchar(45) DEFAULT NULL,
                            PRIMARY KEY (`idfacebook`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


ALTER TABLE `user`
    ADD COLUMN `idfacebook` VARCHAR(45) NULL DEFAULT NULL AFTER `idrole`;



DROP TABLE IF EXISTS `vouchers`;
CREATE TABLE `vouchers`  (
                             `idvouchers` int NOT NULL AUTO_INCREMENT,
                             `nameVoucher` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `quantity` int NULL DEFAULT NULL,
                             `diktat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             `value` int NULL DEFAULT NULL,
                             `startAt` datetime NULL DEFAULT NULL,
                             `finishAt` datetime NULL DEFAULT NULL,
                             `status` int NULL DEFAULT NULL COMMENT '0: lock; 1: active',
                             `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
                             PRIMARY KEY (`idvouchers`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

INSERT INTO `vouchers` VALUES (1, 'Giảm tối đa 400K', 99, 'Đơn tối thiểu 0đ', 400000, '2022-12-23 06:00:00', '2023-06-30 06:00:00', 1, NULL);
INSERT INTO `vouchers` VALUES (2, 'Giảm tối đa 100K', 500, 'Đơn tối thiểu 0đ', 100000, '2023-06-01 06:00:00', '2023-06-10 06:00:00', 1, NULL);
INSERT INTO `vouchers` VALUES (3, 'Giảm tối đa 1 triệu', 10, 'Đơn tối thiểu 500K', 1000000, '2023-06-06 06:00:00', '2023-06-06 23:00:00', 0, NULL);
INSERT INTO `vouchers` VALUES (4, 'Giảm tối đa 350K', 150, 'Đơn tối thiểu 500K', 350000, '2023-05-15 06:00:00', '2023-05-15 13:00:00', 0, NULL);

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for voucher_users
-- ----------------------------
DROP TABLE IF EXISTS `voucher_users`;
CREATE TABLE `voucher_users`  (
                                  `idvouchers` int NOT NULL,
                                  `iduser` int NOT NULL,
                                  `quantity` int NOT NULL,
                                  `isActive` int NOT NULL,
                                  PRIMARY KEY (`idvouchers`, `iduser`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of voucher_users
-- ----------------------------
INSERT INTO `voucher_users` VALUES (1, 2, 1, 1);
INSERT INTO `voucher_users` VALUES (2, 2, 1, 1);
INSERT INTO `voucher_users` VALUES (3, 2, 1, 1);


-- THEM TRUONG PUBLIC KEY VAO TABLE USER
ALTER TABLE `user`
    ADD COLUMN `publickey` VARCHAR(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL;
select * from user;
-- BANG KEY
CREATE TABLE `user_keys` (
                             `iduser` INT NOT NULL,
                             `publicKey` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,
                             PRIMARY KEY (`iduser`),
                             FOREIGN KEY (`iduser`) REFERENCES `user`(`iduser`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


-- THEM TRUONG SIGNATURE CHO TABLE ORDER
ALTER TABLE orders
ADD COLUMN signature TEXT;

-- chinh sua bang order de phu hop gia tri voi java
ALTER TABLE orders MODIFY COLUMN grandtotal DECIMAL(10, 2);

-- Đổi tên trường từ idorders thành idorder
ALTER TABLE `orders`
CHANGE COLUMN `idorders` `idorder` INT(11) NOT NULL AUTO_INCREMENT;

-- Cập nhật tên khóa chính
ALTER TABLE `orders`
DROP PRIMARY KEY,
ADD PRIMARY KEY (`idorder`);

-- Cập nhật tên các khóa ngoại có liên quan
ALTER TABLE `orders`
DROP FOREIGN KEY `fk_couponsidorders`,
DROP FOREIGN KEY `fk_useridorders`,
DROP FOREIGN KEY `fk_addressidorders`;

-- Cập nhật tên các khóa ngoại sau khi thay đổi tên trường
ALTER TABLE `orders`
ADD CONSTRAINT `fk_couponsidorder` FOREIGN KEY (`idcoupons`) REFERENCES `coupons` (`idcoupons`) ON UPDATE CASCADE,
ADD CONSTRAINT `fk_useridorder` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`) ON UPDATE CASCADE,
ADD CONSTRAINT `fk_addressidorder` FOREIGN KEY (`idaddress`) REFERENCES `address` (`idaddress`) ON UPDATE CASCADE;

-- doi kdl cho createat để đồng nhất
ALTER TABLE `invoice`
MODIFY COLUMN `createAt` timestamp(3) NOT NULL DEFAULT current_timestamp(3);


