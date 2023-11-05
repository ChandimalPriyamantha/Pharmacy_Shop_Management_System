-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pharmacyDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pharmacyDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pharmacyDB` DEFAULT CHARACTER SET utf8 ;
USE `pharmacyDB` ;

-- -----------------------------------------------------
-- Table `pharmacyDB`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`admin` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `userID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `joinDate` DATE NULL,
  `salary` DOUBLE NULL,
  `password` VARCHAR(250) NULL,
  'answer' VARCHAR(250) NULL,
  PRIMARY KEY (`serialID`, `userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`staff`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`staff` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `userID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `joinDate` DATE NULL,
  `salary` DOUBLE NULL,
  `password` VARCHAR(250) NULL,
  `position` VARCHAR(45) NULL,
  PRIMARY KEY (`serialID`, `userID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`medicine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`medicine` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `medicineID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `manufacturer` VARCHAR(45) NULL,
  `expireDate` DATE NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`serialID`, `medicineID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`supplier` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `supplierID` VARCHAR(45) NOT NULL,
  `supplierName` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `contactNumber` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `companyRegNo` VARCHAR(45) NULL,
  PRIMARY KEY (`serialID`, `supplierID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`rcoMedicineDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`rcoMedicineDetail` (
  `sequenceID` INT NOT NULL AUTO_INCREMENT,
  `medicineID` VARCHAR(45) NULL,
  `medicineName` VARCHAR(45) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`sequenceID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`rcoShippingDetail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`rcoShippingDetail` (
  `orderID` VARCHAR(255) NOT NULL,
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `address` VARCHAR(255) NULL,
  `phoneNo` VARCHAR(45) NULL,
  `dateAndTime` DATETIME NULL,
  PRIMARY KEY (`serialID`, `orderID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`transaction`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`transaction` (
  `transactionID` VARCHAR(45) NOT NULL,
  `date` DATE NULL,
  `type` VARCHAR(45) NULL,
  `totalAmount` DOUBLE NULL,
  PRIMARY KEY (`transactionID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`sales`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`sales` (
  `salesID` VARCHAR(45) NOT NULL,
  `name` VARCHAR(255) NULL,
  `type` VARCHAR(45) NULL,
  `quantity` INT NULL,
  `dateandTime` DATETIME NULL,
  `amount` DOUBLE NULL,
  PRIMARY KEY (`salesID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`purchaseSupplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`purchaseSupplier` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `supplierID` VARCHAR(45) NULL,
  `supplierName` VARCHAR(45) NULL,
  `companyRegistrationNumber` VARCHAR(45) NULL,
  `phoneNumber` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`serialID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`purchaseMedicine`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`purchaseMedicine` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `medicineID` VARCHAR(45) NOT NULL,
  `quantity` INT NULL,
  PRIMARY KEY (`serialID`, `medicineID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pharmacyDB`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pharmacyDB`.`purchase` (
  `serialID` INT NOT NULL AUTO_INCREMENT,
  `purchaseID` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  `dateAndTime` DATETIME NULL,
  `quantity` INT NULL,
  `supplierID` VARCHAR(45) NULL,
  `amount` DOUBLE NULL,
  PRIMARY KEY (`serialID`, `purchaseID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
