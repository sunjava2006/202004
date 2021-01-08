import math
from db.dbtemplate import DbTemplate


class Admin(DbTemplate):
    def __init__(self):
        super(Admin, self).__init__()

    def add_addmin(self, name, pwd):
        sql = "insert into admin values(seq_admin.nextval, :name,:pwd,:status)"
        return self.save_update(sql, name=name, pwd=pwd, stauts=1)

    def login(self, name, pwd):
        sql = "select * from admin where admin_name=:name and pwd=:pwd and status=1"
        data = self.find(sql, name=name, pwd=pwd)
        if data:
            return data[0]
        else:
            return None


class Types(DbTemplate):
    def __init__(self):
        super(Types, self).__init__()

    def add_type(self, type):
        sql = "insert into types values(seq_types.nextval, :type)"
        return self.save_update(sql, type=type)

    def list(self, page, size):
        sql = """select * from (select t.*, rownum ro from types t order by id desc) where ro>:s and ro<=:e"""
        start = (page-1)*size
        end = page * size
        return self.find(sql, s=start, e=end)

    def have_type(self, type):
        sql = """select * from types where type=:type"""
        data = self.find(sql, type=type)
        return True if data else False

    def total_count(self):
        sql = "select count(*) count from types"
        data = self.find(sql)
        return data[0].get("COUNT")

    def total_page(self, total_count, size):
        return math.ceil(total_count/size)

    def modify_type(self, type, id):
        sql = "update types set type=:type where id=:id"
        return self.save_update(sql, type=type, id=id)

    def del_type(self, id):
        sql = "delete from types where id=:id"
        return self.save_update(sql, id=id)

    def list_all(self):
        sql = "select * from types"
        return self.find(sql)


class Fruits(DbTemplate):
    def __init__(self):
        super(Fruits, self).__init__()

    def type_count(self, typeid):
        sql = """select count(*) count from fruits where type_id=:id"""
        data = self.find(sql, id=typeid)
        return data[0].get("COUNT")

    def add(self, name, type_id, price, origion, unit, photo):
        sql = """insert into fruits(id, name, type_id, price, origion, unit, photo)
        values (seq_fruits.nextval, :name, :type_id, :price, :origion, :unit, :photo)"""
        return self.save_update(sql, name=name, type_id=type_id, price=price, unit=unit, photo=photo, origion=origion)

    def search_fruit(self, page, size, search_type, search_key):
        if search_key:
            if search_type == 'byName':
                sql = "select * from ("\
                         "select a.*, rownum ro from"\
                         "(select * from fruits where name=:key order by id) a where rownum <=:mx) where ro >:mi"

            elif search_type == 'byType':
                sql = "select * from("\
                       "select a.* , rownum ro from"\
                       "(select * from fruits where type_id=(select id from types where type=:key) order by id) a "\
                       "where rownum <=:mx) where ro>:mi"
            else:
                sql = "select * from ("\
                      "select a.*, rownum ro from"\
                      "(select * from fruits where origion=:key order by id) a where rownum <=:mx) where ro >:mi"

            data = self.find(sql, key=search_key, mx=(page*size), mi=(page-1)*size)
        else:
            sql = "select * from ("\
                         "select a.*, rownum ro from"\
                         "(select * from fruits  order by id) a where rownum <=:mx) where ro >:mi"
            data = self.find(sql, mx=(page*size), mi=(page-1)*size)
        return data

    def search_fruit_count(self, search_type, search_key):
        if search_key:
            if search_type == 'byName':
                sql = "select count(*) count from fruits where name=:key"
            elif search_type == 'byType':
                sql = "select count(*) count from fruits where type_id=(select id from types where type=:key)"
            else:
                sql = "select count(*) count from fruits where origion=:key"

            data = self.find(sql, key=search_key)
        else:
            sql = "select count(*) count from fruits"
            data = self.find(sql)

        return data[0].get("COUNT")

    def total_page(self, total_count, size):
        return math.ceil(total_count/size)

    def list_by_type_id(self,type_id, page, size=10):
        sql = "select * from("\
              "select a.* , rownum ro from(select * from fruits where type_id=:id order by id desc)a "\
              "where rownum <=:mx)where ro >:mi"
        return self.find(sql, mx=page*size, mi=(page-1)*size, id=type_id)

    def count_by_type_id(self, type_id):
        sql = 'select count(*) count from fruits where type_id=:id'
        return self.find(sql, id=type_id)[0].get("COUNT")

class Users(DbTemplate):
    def __init__(self):
        super().__init__()
        # super(Users, self).__init__()
        # DbTemplate.__init__(self)

    def get_id(self):
        sql = 'select seq_users.nextval id from dual'
        return self.find(sql)[0].get('ID')

    def add_user(self,id, user_name, pwd, phone_no):
        sql = 'insert into users(id, user_name, pwd, status, phone) values (:id, :user_name, :pwd, 1, :phone_no)'
        return self.save_update(sql, id=id, user_name=user_name, pwd=pwd, phone_no=phone_no)

    def add_address(self,id, address):
        sql = 'insert into user_addresses(id, user_id, address) values (seq_user_addresses.nextval, :id, :addr)'
        return self.save_update(sql, id=id, addr=address)

    def regist(self, user_name, pwd, phone_no, address):
        id = self.get_id()
        self.add_user(id, user_name, pwd, phone_no)
        self.add_address(id, address)

    def login(self, user_name, pwd):
        sql = 'select * from users where user_name=:user_name and pwd=:pwd'
        data = self.find(sql, user_name=user_name, pwd=pwd)
        if data:
            return data[0]
        else:
            return None




