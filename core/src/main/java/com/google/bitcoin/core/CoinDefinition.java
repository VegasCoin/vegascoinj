package com.google.bitcoin.core;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;
import java.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: HashEngineering
 * Date: 8/13/13
 * Time: 7:23 PM
 */
public class CoinDefinition {
        public static final String coinName = "Vegas";
        public static final String coinTicker = "VGC";
        public static final String coinURIScheme = "vegas";
        public static final String cryptsyMarketId = "";
        public static final String cryptsyMarketCurrency = "BTC";
        public static final String alternateExchangeInfo = "";
//        public static final String alternateExchangeInfo = "http://www.vegascoin.co/coin_api/coin_api.php?coin_id=33";


        public static final String BLOCKEXPLORER_BASE_URL_PROD = "http://explorer.vegascoin.co/";
        public static final String BLOCKEXPLORER_BASE_URL_TEST = "http://explorer.vegascoin.co/";

        public static final String DONATION_ADDRESS = "F85ytB5qH87aHskpauQi6YWdRZPQgNubX4";  //HashEngineering donation VGC address

        enum CoinHash {
            SHA256,
            scrypt
        };
        public static final CoinHash coinHash = CoinHash.scrypt;
        //Original Values
        public static final int TARGET_TIMESPAN = (int)(1 * 24 * 60 * 60);  // 720 blocks; 6 hours
        public static final int TARGET_SPACING = (int)(4 * 30);  // 30 seconds per block.

        public static final int INTERVAL = TARGET_TIMESPAN / TARGET_SPACING;  // 720 blocks

        public static final int getInterval(int height, boolean testNet) {

            return INTERVAL;
        }
        public static final int getTargetTimespan(int height, boolean testNet) {

            return TARGET_TIMESPAN;
        }
        public static int spendableCoinbaseDepth = 15; //main.h: static const int COINBASE_MATURITY
        public static final int MAX_MONEY = 100000000;                 //main.h:  MAX_MONEY
        public static final String MAX_MONEY_STRING = "100000000";     //main.h:  MAX_MONEY

        public static final BigInteger DEFAULT_MIN_TX_FEE = BigInteger.valueOf(100);   // MIN_TX_FEE
        public static final BigInteger DUST_LIMIT =      Utils.toNanoCoins("0.00000100"); //main.h DUST_SOFT_LIMIT        0.00001 coins
        public static final BigInteger DUST_HARD_LIMIT = Utils.toNanoCoins("0.00000010"); //main.h DUST_HARD_LIMIT        0.000001 coins

        public static final int PROTOCOL_VERSION = 70002;          //version.h PROTOCOL_VERSION
        public static final int MIN_PROTOCOL_VERSION = 209;        //version.h MIN_PROTO_VERSION

        public static final boolean supportsBloomFiltering = true; //Requires PROTOCOL_VERSION 70000 in the client

        public static final int Port    = 52400;       //protocol.h GetDefaultPort(testnet=false)
        public static final int TestPort = 52500;      //protocol.h GetDefaultPort(testnet=true)

        //
        //  Production
        //
        public static final int AddressHeader = 58;               //base58.h CBitcoinAddress::PUBKEY_ADDRESS
        public static final int p2shHeader = 5;                   //base58.h CBitcoinAddress::SCRIPT_ADDRESS
        //public static final int dumpedPrivateKeyHeader = 128;   //common to all coins
        public static final long PacketMagic = 0xfcd9b7dd;        // Vegas packeg magic value

        //Genesis Block Information from main.cpp: LoadBlockIndex
        static public long genesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long genesisBlockTime = 1392172369L;                       //main.cpp: LoadBlockIndex
        static public long genesisBlockNonce = (2893208);                         //main.cpp: LoadBlockIndex
        static public String genesisHash = "4ac6a48f08e36df631c79a5929c687f22958f8ce92d199f077cbf4db77feeb00"; //main.cpp: hashGenesisBlock
        static public int genesisBlockValue = 0;                                                              //main.cpp: LoadBlockIndex
        //taken from the raw data of the block explorer
        static public String genesisXInBytes = "04ffff001d010449636e6e2e636f6d20323031342d30322d3131202d2049206469646e2774206d65616e20746f206b696c6c2c20274974206a75737420776f726b6564206f757420746861742077617927";   //"cnn.com 2014-02-11 - I didn't mean to kill, 'It just worked out that way'"
        static public String genessiXOutBytes = "";

        //net.cpp strDNSSeed
        static public String[] dnsSeeds = new String[] {
                "node.vegascoin.co", // US
                "jp.nodes.vegascoin.co", // JAPAN
                "cn.nodes.vegascoin.co", // China
                "eu.nodes.vegascoin.co", // Europe
                "0.nodes.vegascoin.co",
                "1.nodes.vegascoin.co"
        };

        //
        // TestNet - Vegascoin - not tested
        //
        public static final boolean supportsTestNet = true;
        public static final int testnetAddressHeader = 112;             //base58.h CBitcoinAddress::PUBKEY_ADDRESS_TEST
        public static final int testnetp2shHeader = 196;             //base58.h CBitcoinAddress::SCRIPT_ADDRESS_TEST
        public static final long testnetPacketMagic = 0xfbc0b8db;      //0xfc, 0xc1, 0xb7, 0xdc
        public static final String testnetGenesisHash = "525fefa347d20b2050f386373bbbd2df65cf01731fe2555b7ceff8fec87eb1a3";
        static public long testnetGenesisBlockDifficultyTarget = (0x1e0ffff0L);         //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockTime = 1392163921L;                       //main.cpp: LoadBlockIndex
        static public long testnetGenesisBlockNonce = (1283003);                        //main.cpp: LoadBlockIndex

        public static int nDifficultySwitchHeight = 25000;


        public static final boolean usingNewDifficultyProtocol(int height)
        { return height >= nDifficultySwitchHeight;}



        //main.cpp GetBlockValue(height, fee)

        public static final BigInteger GetBlockReward(int height)
        {
            return Utils.toNanoCoins(30, 0).shiftRight(height / subsidyDecreaseBlockCount);
        }

        public static int subsidyDecreaseBlockCount = 22471626;     //main.cpp GetBlockValue(height, fee)

        public static BigInteger proofOfWorkLimit = Utils.decodeCompactBits(0x1e0fffffL);  //main.cpp bnProofOfWorkLimit (~uint256(0) >> 20); // Vegas: starting difficulty is 1 / 2^12

        static public String[] testnetDnsSeeds = new String[] {
                "not supported"
        };
        //from main.h: CAlert::CheckSignature
        public static final String SATOSHI_KEY = "";
        public static final String TESTNET_SATOSHI_KEY = "";
        /** The string returned by getId() for the main, production network where people trade things. */
        public static final String ID_MAINNET = "co.vegascoin.production";
        /** The string returned by getId() for the testnet. */
        public static final String ID_TESTNET = "co.vegascoin.test";
        /** Unit test network. */
        public static final String ID_UNITTESTNET = "co.vegascoin.unittest";

        //checkpoints.cpp Checkpoints::mapCheckpoints
        public static void initCheckpoints(Map<Integer, Sha256Hash> checkpoints)
        {
            checkpoints.put(      0, new Sha256Hash("4ac6a48f08e36df631c79a5929c687f22958f8ce92d199f077cbf4db77feeb00"));
            checkpoints.put(  23674, new Sha256Hash("dfadbe92367937fdd627aaa6506f1b70373653f66fda4d3bbabe37a6807c6ce4"));
            checkpoints.put( 327199, new Sha256Hash("b46a3284600ba22ac975971445fd031ec190c690ea98e25e5f7ad22617ddc18c"));
        }
}
