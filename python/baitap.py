from abc import ABC, abstractmethod
class AbcNhanVien(ABC):


    # Thuộc tính đặt trong hàm__init__
    def __init__(self, ma_nv, ho_ten ,luong_cb):
        self._ma_nv = ma_nv
        self._ho_ten = ho_ten
        self._luong_cb = luong_cb
        self._luong_ht = 0

    def in_nv(self):
        print(f" [{self._ma_nv},{self._ho_ten},{self._luong_cb},{self._luong_ht}]", end ="")

    @abstractmethod
    def tinh_luong_ht(self):
        pass  # Phải được triển khai trong các lớp con




class NVVanPhong(AbcNhanVien):
    # Thuộc tính đặt trong hàm__init__
    def __init__(self, ma_nv, ho_ten ,luong_cb, so_gio):
        super().__init__(ma_nv, ho_ten ,luong_cb)
        self.__so_gio = so_gio
        self.__tro_cap = 0

    def __str__(self):  # in ra dia chi vung nho
        return f" [{self._ma_nv},{self._ho_ten},{self._luong_cb},{self.__so_gio},{self._luong_ht},{self.__tro_cap}]"

    # Phương thức
    def in_nv(self):
        super().in_nv()
        print(self.__so_gio)
        # print(f" [{self.ma_nv},{self.ho_ten},{self.luong_cb},{self.so_ng},{self.luong_ht}]")

    def tinh_luong_ht(self):
        tro_cap = 5_000_000 if self.__so_gio > 100 else 0
        self._luong_ht = self._luong_cb + self.__so_gio * 150_000 + tro_cap
        return self._luong_ht





# self chinh la dia chi vung nho

class NVSanXuat(AbcNhanVien):
    # Thuộc tính đặt trong hàm__init__
    def __init__(self, ma_nv, ho_ten ,luong_cb, so_sp):
        super().__init__(ma_nv, ho_ten ,luong_cb)

        self.__so_sp = so_sp

    def __str__(self):  # in ra dia chi vung nho
        return f" [{self._ma_nv},{self._ho_ten},{self._luong_cb},{self.__so_sp},{self._luong_ht}]"

    # Phương thức
    def in_nv(self):
        print(f" [{self._ma_nv},{self._ho_ten},{self._luong_cb},{self.__so_sp},{self._luong_ht}]")

    def tinh_luong_ht(self):
        self._luong_ht = self._luong_cb + self.__so_sp * 175_000
        if self.__so_sp >150:
            self._luong_ht = self._luong_ht*1.2
        return self._luong_ht

class NVQuanLy(AbcNhanVien):
    def __init__(self, ma_nv, ho_ten ,luong_cb ,he_so,thuong):
        super().__init__(ma_nv, ho_ten ,luong_cb)
        self.__he_so =he_so
        self.__thuong = thuong




    def __str__(self):
        return f"[{self._ma_nv}, {self._ho_ten}, {self._luong_cb},{self.__he_so},{ self.__thuong}, {self._luong_ht}]"
    def tinh_luong_ht(self):
        self._luong_ht = self._luong_cb * self.__he_so + self.__thuong
        return self._luong_ht
class AbcDaiLy(ABC):
    @abstractmethod
    def init_ds_nv(self,ds:list):
        pass

    @abstractmethod
    def tinh_luong_ht(self):
        pass

    @abstractmethod
    def tim_nv(self):
        pass

    @abstractmethod
    def cap_nhat_luong_cb(self):
        pass

class DaiLy(AbcDaiLy):
    def __init__(self, ma_dl, ten_dl):
        self.__ma_dl = ma_dl
        self.__ten_dl = ten_dl
        self.__ds = []

    @property
    def ds(self):
        return self.__ds
    def tim_nv(self):
        pass
    def init_ds_nv(self, ds:list):
        # khoi tao du lieu cac nhan vien trong cong ty
        if ds:
            self.__ds = ds.copy()

        else:

            vp1 = NVVanPhong("101", "Nguyễn A", 4_500_000, 200)
            vp2 = NVVanPhong("102", "Nguyễn B", 5_600_000, 100)
            vp3 = NVVanPhong("103", "Nguyễn C", 8_900_000, 90)
            sx1 = NVSanXuat("201", "Nguyễn D", 7_800_000, 250)
            sx2 = NVSanXuat("202", "Nguyễn E", 4_500_000, 110)
            sx3 = NVSanXuat("203", "Nguyễn F", 6_600_000, 360)
            ql1 = NVQuanLy("301", "Nguyễn G", 8_500_000, 1.3, 19_500_000)
            ql2 = NVQuanLy("302", "Nguyễn H", 7_600_000, 1.2, 18_600_000)

            self.__ds.extend([vp1, vp2, vp3, sx1, sx2, sx3, ql1, ql2])
            return len(self.__ds)

    def print_ds_nv(self):
        """ in ds nhan vien"""
        for nv in self.__ds:
            print(nv)

    def print_ds_nv_v2(self):
        # 2. v2 in danh sach nhan vien
        for nv in self.__ds:
            nv.in_nv()
            # if isinstance(nv, NVBanHang):
            # nv.in_nv_bh()
            ##elif isinstance(nv, NVVanPhong):
            # nv.in_nv_vp()

    def tinh_luong_ht(self):
        # 3. Tinh luong hang thang cho cac nhan vien
        for nv in self.__ds:
            nv.tinh_luong_ht()


    def tim_nv(self, ma_nv_can_tim):


        for nv in self.__ds:
          if nv._ma_nv == ma_nv_can_tim:
            print("Nhân viên tìm thấy:")
            return nv.in_nv()
          else:
            print("Không tìm thấy nhân viên với mã:", ma_nv_can_tim)


    def cap_nhat_luong_cb(self, ma_nv_can_sua, luong_moi):
        for nv in self.__ds:
           if nv._ma_nv == ma_nv_can_sua:
            nv._luong_cb = luong_moi
            return True
        return False



    def nv_luong_cb_thap_nhat(self):
         nv = min(self.__ds, key=lambda nv: nv._luong_cb)
         return nv.in_nv()


    def NV_SX_luong_ht_cao_nhat(self):
        nv_sx = [nv for nv in self.__ds if isinstance(nv, NVSanXuat)]
        if nv_sx:
            nv = max(nv_sx, key=lambda nv: nv.tinh_luong_ht())
            return nv.in_nv()
        else:
            print("Không có nhân viên sản xuất nào.")


if __name__ == '__main__':
    print("Test:1. Khoi tao du lieu cac nhan vien trong cong ty")
    ct = DaiLy(369, "DAI LY THANH CONG")
    so_nv = ct.init_ds_nv([])
    print("\t Ket qua:", so_nv, "nhan vien")
    print("\n Test:2 in ds nhan vien:")
    ct.print_ds_nv()
    print()
    ct.print_ds_nv_v2()
    print("\n Test: 3. Tinh luong hang thang cho cac nhan vien: ")
    ct.tinh_luong_ht()
    ct.print_ds_nv()

    # tinh dong goi : han che viec goi

    print("\n Test: 4. Tim ma nhan vien: ")

    Ma_nhan_vien = input('Nhập mã nhân viên: ')
    ct.tim_nv(Ma_nhan_vien)
    print("\n Test: 5. Cap nhat luong co ban theo ma nhan vien: ")
    Ma_nhan_vien = input('Nhập mã nhân viên: ')
    Luong_moi = float(input('Nhap luong moi:'))
    if ct.cap_nhat_luong_cb(Ma_nhan_vien,Luong_moi) == True:
          ct.cap_nhat_luong_cb(Ma_nhan_vien,Luong_moi)
          ct.print_ds_nv()
    else:
        print("\n  Không tìm thấy mã nhân viên")


    print("\n Test: 7. Tim nhân viên có lương hàng tháng thấp nhất ")
    ct.nv_luong_cb_thap_nhat()
    print("\n Test:8. Tim nhân viên bán hàng có lương hàng tháng cao nhất ")
    ct.NV_SX_luong_ht_cao_nhat()


