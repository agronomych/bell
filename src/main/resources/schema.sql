--Making new schema if not exists
CREATE SCHEMA IF NOT EXISTS bell;
USE bell;

CREATE TABLE IF NOT EXISTS `Organizations` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `inn` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  `fullName` VARCHAR(45) NULL,
  `kpp` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bell`.`offices`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Offices` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `orgId` INT NULL,
  `name` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `isActive` TINYINT NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `orgId`
    FOREIGN KEY (`orgId`)
    REFERENCES `Organizations` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `orgId_idx` ON `Offices` (`orgId` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Docs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Docs` (
  `code` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Countries`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Countries` (
  `code` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`code`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `officeId` INT NULL,
  `firstName` VARCHAR(45) NULL,
  `lastName` VARCHAR(45) NULL,
  `middleName` VARCHAR(45) NULL,
  `position` VARCHAR(45) NULL,
  `docCode` INT NULL,
  `citizenshipCode` INT NULL,
  `phone` VARCHAR(45) NULL,
  `docName` VARCHAR(45) NULL,
  `docNumber` VARCHAR(45) NULL,
  `docDate` DATE,
  `citizenshipName` VARCHAR(45) NULL,
  `isIdentified` TINYINT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `officeId`
    FOREIGN KEY (`officeId`)
    REFERENCES `Offices` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `docCode`
    FOREIGN KEY (`docCode`)
    REFERENCES `Docs` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `citizenshipCode`
    FOREIGN KEY (`citizenshipCode`)
    REFERENCES `Countries` (`code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `officeId_idx` ON `Users` (`officeId` ASC);

CREATE INDEX `docCode_idx` ON `Users` (`docCode` ASC);

CREATE INDEX `citizenshipCode_idx` ON `Users` (`citizenshipCode` ASC);