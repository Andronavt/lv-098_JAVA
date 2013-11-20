package tc.lv.dao.implementations;

import tc.lv.dao.IpInterface;
import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.NotValidIp;

public enum IpQueryEnum implements IpInterface {
    IP {

        @Override
        public String findAll() {
            return IpAddress.FIND_ALL;
        }

        @Override
        public String findAllNotValid() {
            return IpAddress.FIND_ALL_NOT_VALID;
        }

        @Override
        public String findAllValid() {
            return IpAddress.FIND_ALL_VALID;
        }

        @Override
        public String findBlackIpByName() {
            return IpAddress.FIND_WHITE_OR_BLACK_IP_BY_NAME;
        }

        @Override
        public String findByAddress() {
            return IpAddress.FIND_BY_ADDRESS;
        }

        @Override
        public String findBySource() {
            return IpAddress.FIND_BY_SOURCE;
        }

        @Override
        public String findUndefinedlist() {
            return IpAddress.FIND_UNDEFINEDLIST;
        }

        @Override
        public String findWhiteOrBlackIpByName() {
            return IpAddress.FIND_WHITE_OR_BLACK_IP_BY_NAME;
        }

        @Override
        public String findWhiteOrBlackList() {
            return IpAddress.FIND_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findWhiteOrBlackListByCity() {
            return IpAddress.FIND_WHITE_OR_BLACK_LIST_BY_CITY;
        }

        @Override
        public String findWhiteOrBlackListByCountry() {
            return IpAddress.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY;
        }

        @Override
        public String countAll() {
            return IpAddress.COUNT_ALL;
        }

        @Override
        public String countWhiteOrBlackList() {
            return IpAddress.COUNT_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findCitiesWhiteOrBlackList() {
            return IpAddress.FIND_CITIES_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findCountriesWhiteOrBlackList() {
            return IpAddress.FIND_COUNTRIES_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findIpListByCity() {
            return IpAddress.FIND_IPLIST_BY_CITY;
        }

        @Override
        public String findIpListByCountry() {
            return IpAddress.FIND_IPLIST_BY_COUNTRY;
        }

        @Override
        public String countWhiteOrBlackListByCountry() {
            return IpAddress.COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY;
        }
    },
    IP_NOT_VALID {

        @Override
        public String findAll() {
            return NotValidIp.FIND_ALL;
        }

        @Override
        public String findAllNotValid() {
            return NotValidIp.FIND_ALL;
        }

        @Override
        public String findAllValid() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findBlackIpByName() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findByAddress() {
            return NotValidIp.FIND_BY_ADDRESS;
        }

        @Override
        public String findBySource() {
            return NotValidIp.FIND_BY_SOURCE;
        }

        @Override
        public String findUndefinedlist() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findWhiteOrBlackListByCity() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findWhiteOrBlackListByCountry() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findWhiteOrBlackIpByName() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findWhiteOrBlackList() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findCitiesWhiteOrBlackList() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findCountriesWhiteOrBlackList() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String countAll() {
            return NotValidIp.COUNT_ALL;
        }

        @Override
        public String countWhiteOrBlackList() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findIpListByCity() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String findIpListByCountry() {
            throw new IllegalArgumentException("This method didn't supported");
        }

        @Override
        public String countWhiteOrBlackListByCountry() {
            throw new IllegalArgumentException("This method didn't supported");
        }
    },
    IP_V4 {

        @Override
        public String findAll() {
            return IpV4Address.FIND_ALL;
        }

        @Override
        public String findAllNotValid() {
            return IpV4Address.FIND_ALL_NOT_VALID;
        }

        @Override
        public String findAllValid() {
            return IpV4Address.FIND_ALL_VALID;
        }

        @Override
        public String findBlackIpByName() {
            return IpV4Address.FIND_WHITE_OR_BLACK_IP_BY_NAME;
        }

        @Override
        public String findByAddress() {
            return IpV4Address.FIND_BY_ADDRESS;
        }

        @Override
        public String findBySource() {
            return IpV4Address.FIND_BY_SOURCE;
        }

        @Override
        public String findUndefinedlist() {
            return IpV4Address.FIND_UNDEFINEDLIST;
        }

        @Override
        public String findWhiteOrBlackListByCity() {
            return IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY;
        }

        @Override
        public String findWhiteOrBlackListByCountry() {
            return IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY;
        }

        @Override
        public String findWhiteOrBlackIpByName() {
            return IpV4Address.FIND_WHITE_OR_BLACK_IP_BY_NAME;
        }

        @Override
        public String findWhiteOrBlackList() {
            return IpV4Address.FIND_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findCitiesWhiteOrBlackList() {
            return IpV4Address.FIND_CITIES_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findCountriesWhiteOrBlackList() {
            return IpV4Address.FIND_COUNTRIES_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String countAll() {
            return IpV4Address.COUNT_ALL;
        }

        @Override
        public String countWhiteOrBlackList() {
            return IpV4Address.COUNT_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findIpListByCity() {
            return IpV4Address.FIND_IPLIST_BY_CITY;
        }

        @Override
        public String findIpListByCountry() {
            return IpV4Address.FIND_IPLIST_BY_COUNTRY;
        }

        @Override
        public String countWhiteOrBlackListByCountry() {
            return IpV4Address.COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY;
        }
    },
    IP_V6 {
        @Override
        public String findAll() {
            return IpV6Address.FIND_ALL;
        }

        @Override
        public String findAllNotValid() {
            return IpV6Address.FIND_ALL_NOT_VALID;
        }

        @Override
        public String findAllValid() {
            return IpV6Address.FIND_ALL_VALID;
        }

        @Override
        public String findBlackIpByName() {
            return IpV6Address.FIND_WHITE_OR_BLACK_IP_BY_NAME;
        }

        @Override
        public String findByAddress() {
            return IpV6Address.FIND_BY_ADDRESS;
        }

        @Override
        public String findBySource() {
            return IpV6Address.FIND_BY_SOURCE;
        }

        @Override
        public String findUndefinedlist() {
            return IpV6Address.FIND_UNDEFINEDLIST;
        }

        @Override
        public String findWhiteOrBlackListByCity() {
            return IpV6Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY;
        }

        @Override
        public String findWhiteOrBlackListByCountry() {
            return IpV6Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY;
        }

        @Override
        public String findWhiteOrBlackIpByName() {
            return IpV6Address.FIND_WHITE_OR_BLACK_IP_BY_NAME;
        }

        @Override
        public String findWhiteOrBlackList() {
            return IpV6Address.FIND_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findCitiesWhiteOrBlackList() {
            return IpV6Address.FIND_CITIES_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findCountriesWhiteOrBlackList() {
            return IpV6Address.FIND_COUNTRIES_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String countAll() {
            return IpV6Address.COUNT_ALL;
        }

        @Override
        public String countWhiteOrBlackList() {
            return IpV6Address.COUNT_WHITE_OR_BLACK_LIST;
        }

        @Override
        public String findIpListByCity() {
            return IpV6Address.FIND_IPLIST_BY_CITY;
        }

        @Override
        public String findIpListByCountry() {
            return IpV6Address.FIND_IPLIST_BY_COUNTRY;
        }

        @Override
        public String countWhiteOrBlackListByCountry() {
            return IpV6Address.COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY;
        }
    };

}
