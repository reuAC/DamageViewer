# DamageViewer
轻量的伤害显示插件，支持动态开关各类显示。

## 介绍
该插件适用于Spigot1.8及以上。  

支持通过标题信息、对话信息显示特定格式的伤害。  
支持通过赋予玩家各类权限的方式，开关各类显示，借由此功能可以使得玩家自定义各类显示的开关。

**注意：玩家如果没有对应的权限节点，则不会有对应的伤害显示。**
## 指令
`/damageviewer` 重载配置。  
**缩写：`/dver`**

## 配置文件
插件成功启动后，会在plugins文件夹下生成配置文件，位于 `plugins/DamageViewer/config.yml`  

```yaml
# 该选项为true时，受攻击者为玩家时，才会有伤害显示。
OnlyPlayer: true
# 当攻击命中时的信息发送配置。
Message:
  # 是否启用信息
  Enable: true
  # 是否在远程攻击命中后发送信息
  OnShot: true
  # 是否在近战攻击命中后发送信息
  OnAttack: true
  # 正常信息
  normal: "&a%Damager% 你对 %Damagee% 造成了 %Damage_value% 伤害，目前他还剩 %Damagee_Max_Health%/%Damagee_Health% 滴血"
  # 造成击杀时的信息。
  die: "&7%Damager% 你对 %Damagee% 造成了 %Damage_value% 伤害，他被你成功击杀了！"
# 当攻击命中时的屏幕标题发送配置。
Title:
  # 是否启用屏幕标题
  Enable: true
  # 是否在远程攻击命中后发送屏幕标题
  OnShot: true
  # 是否在近战攻击命中后发送屏幕标题
  OnAttack: true
  # 正常屏幕标题的主标题
  normal: "&c&l伤害 &7%Damage_value%"
  # 正常屏幕标题的副标题
  normal_sub: "%Damagee_Max_Health%/%Damagee_Health%"
  # 造成击杀时屏幕标题的主标题
  die: "伤害 %Damage_value%"
  # 造成击杀时屏幕标题的主标题
  die_sub: "成功击杀！"
```

## 权限节点
`damageviewer.main` 使用重载指令。  
`damageviewer.onattack.title` **直接**受击时，**标题信息**是否显示。  
`damageviewer.onattack.message` **直接**受击时，**对话框信息**是否显示。  
`damageviewer.onattack.title` 受到**远程**攻击时，**标题信息**是否显示。  
`damageviewer.onattack.message` 受到**远程**攻击时，**对话框信息**是否显示。  

## 内置变量
`%Damager%` 攻击者ID  
`%Damagee_Health%` 受击者血量  
`%Damagee%` 受击者ID  
`%Damagee_Max_Health%` 受击者最大生命值  
`%Damage_value%` 受击者当前生命值

## 使用方法
1. 将编译完成的jar包放入plugins文件夹中，重启服务器。
