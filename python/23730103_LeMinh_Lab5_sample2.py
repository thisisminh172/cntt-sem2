from abc import ABC, abstractmethod

class KhachHang(ABC):
    def __init__(self, maKH, tenChuHo, chiSoCu, chiSoMoi):
        self._maKH = maKH
        self._tenChuHo = tenChuHo
        self._chiSoCu = chiSoCu
        self._chiSoMoi = chiSoMoi

    @property
    def maKH(self):
        return self._maKH
    
    @property
    def tenChuHo(self):
        return self._tenChuHo

    def __str__(self):
        return f"Mã KH: {self._maKH}, tên chủ hộ: {self._tenChuHo}, chỉ số cũ: {self._chiSoCu}, chỉ số mới: {self._chiSoMoi}"

    @abstractmethod
    def tinhTienDien(self):
        pass

class HoGiaDinh(KhachHang):
    def __init__(self, maKH, tenChuHo, chiSoCu, chiSoMoi):
        super().__init__(maKH, tenChuHo, chiSoCu, chiSoMoi)
        self.__tienDien = 0

    def tinhTienDien(self):
        soDienSuDung = self._chiSoMoi - self._chiSoCu
        if soDienSuDung <= 100:
            self.__tienDien = soDienSuDung * 3500
        elif soDienSuDung > 100:
            self.__tienDien = soDienSuDung * 5500

    @property
    def tienDien(self):
        return self.__tienDien

class HoKinhDoanh(KhachHang):
    def __init__(self, maKH, tenChuHo, chiSoCu, chiSoMoi, heSoSuDung):
        super().__init__(maKH, tenChuHo, chiSoCu, chiSoMoi)
        self.__heSoSuDung = heSoSuDung
        self.__tienDien = 0

    def tinhTienDien(self):
        soDienSuDung = self._chiSoMoi - self._chiSoCu
        if soDienSuDung <= 500:
            self.__tienDien = soDienSuDung * 5500 * self.__heSoSuDung
        elif soDienSuDung > 500:
            self.__tienDien = soDienSuDung * 7000 * self.__heSoSuDung

    @property
    def tienDien(self):
        return self.__tienDien


class HoSanXuat(KhachHang):
    def __init__(self, maKH, tenChuHo, chiSoCu, chiSoMoi, heSoSuDung):
        super().__init__(maKH, tenChuHo, chiSoCu, chiSoMoi)
        self.heSoSuDung = heSoSuDung
        self.__tienDien = 0

    def tinhTienDien(self):
        soDienSuDung = self._chiSoMoi - self._chiSoCu
        self.__tienDien = soDienSuDung * 7000 * self.heSoSuDung

    @property
    def tienDien(self):
        return self.__tienDien
    
class Phuong:
    def __init__(self, tenPhuong):
        self.tenPhuong = tenPhuong
        self.danhSachKhachHang = []

    def themKhachHang(self, khachHang):
        self.danhSachKhachHang.append(khachHang)

    def inDanhSachKhachHang(self):
        print(f"Phường: {self.tenPhuong}")
        for khachHang in self.danhSachKhachHang:
            print(f"{khachHang}, số tiền điện: {khachHang.tienDien} VND")

    """ Yêu cầu 1: Tạo danh sách 7 khách hàng """
    def khoiTaoDanhSachKhachHang(self):
        print("1. Tạo danh sách 7 khách hàng:")
        self.themKhachHang(HoKinhDoanh(123, "A", 120, 960, 1.8))
        self.themKhachHang(HoGiaDinh(124, "B", 400, 460))
        self.themKhachHang(HoKinhDoanh(125, "C", 300, 689, 1.3))
        self.themKhachHang(HoSanXuat(126, "D", 150, 965, 1.5))
        self.themKhachHang(HoGiaDinh(127, "E", 500, 999))
        self.themKhachHang(HoSanXuat(128, "F", 350, 987, 1.6))
        self.themKhachHang(HoSanXuat(129, "G", 100, 989, 1.9))

    """ Yêu cầu 2: Tính tiền điện cho từng khách hàng """
    def tinhTienDienChoTatCaKhachHang(self):
        print("2. Tính tiền điện cho từng khách hàng:")
        for khachHang in self.danhSachKhachHang:
            khachHang.tinhTienDien()
            # print(f"Khách hàng {khachHang.tenChuHo} có tiền điện là: {khachHang.tienDien} VND")

    """ Yêu cầu 3: Tìm kiếm khách hàng theo mã khách hàng"""
    def timKhachHang(self, maKH):
        print("3. Tìm kiếm khách hàng theo mã khách hàng:")
        print(f"Tìm kiếm khách hàng với mã: {maKH}")
        for khachHang in self.danhSachKhachHang:
            if khachHang.maKH == maKH:
                print(khachHang)
                return
        print("Không tìm thấy khách hàng với mã:", maKH)
        
    
    """ Yêu cầu 4: Tính trung bình tiền điện của tất cả khách hàng trong phường """
    def tinhTrungBinhTienDien(self):
        print("4. Tính trung bình tiền điện của tất cả khách hàng trong phường:")
        tongTienDien = 0
        soKhachHang = len(self.danhSachKhachHang)
        if soKhachHang == 0:
            return print(f"Tiền điện trung bình của Phường {self.tenPhuong} là: {tongTienDien} VND")
        for khachHang in self.danhSachKhachHang:
            tongTienDien += khachHang.tienDien
        return print(f"Tiền điện trung bình của Phường {self.tenPhuong} là: {tongTienDien / soKhachHang} VND")

    """ Yêu cầu 5: Tìm khách hàng có tiền điện lớn nhất """
    def timKhachHangMax(self):
        print("5. Tìm khách hàng có tiền điện lớn nhất:")
        khachHangMax = self.danhSachKhachHang[0]
        for khachHang in self.danhSachKhachHang:
            if khachHang.tienDien > khachHangMax.tienDien:
                khachHangMax = khachHang
        return print(f"Khách hàng có tiền điện lớn nhất là: {khachHangMax.tenChuHo} với số tiền là: {khachHangMax.tienDien} VND")
    
    """ Yêu cầu 6: Tìm khách hàng có tiền điện nhỏ nhất """
    def timKhachHangMin(self):
        print("6. Tìm khách hàng có tiền điện nhỏ nhất:")
        khachHangMin = self.danhSachKhachHang[0]
        for khachHang in self.danhSachKhachHang:
            if khachHang.tienDien < khachHangMin.tienDien:
                khachHangMin = khachHang
        return print(f"Khách hàng có tiền điện nhỏ nhất là: {khachHangMin.tenChuHo} với số tiền là: {khachHangMin.tienDien} VND")
    

if __name__ == "__main__":
    phuong = Phuong("Tân Sơn Nhất")
    phuong.khoiTaoDanhSachKhachHang()
    phuong.inDanhSachKhachHang()
    phuong.tinhTienDienChoTatCaKhachHang()
    phuong.inDanhSachKhachHang()
    phuong.tinhTrungBinhTienDien()
    phuong.timKhachHang(125)
    phuong.timKhachHangMax()
    phuong.timKhachHangMin()
