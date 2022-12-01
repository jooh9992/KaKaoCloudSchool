const Sequelize = require('sequelize');

module.exports = class Domain extends Sequelize.Model {
  static init(sequelize) {
    return super.init({
      host: {
        type: Sequelize.STRING(80),
        allowNull: false,
      },
      clientSecret: {
        type: Sequelize.STRING(36),
        allowNull: false,
      },
      type: {
        type: Sequelize.ENUM('free', 'premium'),
        allowNull: false,
      },
    }, 
    {
        sequelize,
        timestamps: true,
        underscored:false,
        paranoid: true,
        modelName: "Domain",
        tableName: "domains",
      });
    }
   static associate(db) {
    //User 와 Domain 은 1:N
    //User의 기본키가 Domain에 외래키로 추가됨
      db.Domain.belongsTo(db.User);
    }
  };
  