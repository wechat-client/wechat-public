package com.wechat.message.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.wechat.common.exception.WechatEcxeption;
import com.wechat.common.utils.MessageUtil;
import com.wechat.message.dao.IMessageDao;
import com.wechat.message.pojo.Message;
import com.wechat.message.pojo.article.Article;
import com.wechat.message.pojo.article.ArticleMessage;
import com.wechat.message.pojo.href.HrefMessage;
import com.wechat.message.pojo.image.Image;
import com.wechat.message.pojo.image.ImageMessage;
import com.wechat.message.pojo.local.LocalMessage;
import com.wechat.message.pojo.music.Music;
import com.wechat.message.pojo.music.MusicMessage;
import com.wechat.message.pojo.text.TextMessage;
import com.wechat.message.pojo.vedio.Vedio;
import com.wechat.message.pojo.vedio.VedioMessage;
import com.wechat.message.pojo.voice.Voice;
import com.wechat.message.pojo.voice.VoiceMessage;

/**
 * @ file_name MessageDaoJDBCImpl.java
 * @ author liu.sheng.qi (liu.sheng.qi@fesco.com.cn)
 * @ date 2013年12月10日下午1:26:33
 * @ description message dao JDBC 实现
 * @ reviewed_by 
 */
@Repository("messageDao")
public class MessageDaoJDBCImpl implements IMessageDao {

	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	/*
	 * (non-Javadoc)
	 * @see com.wechat.message.dao.IMessageDao#saveMessage(com.wechat.message.pojo.Message)
	 */
	public boolean saveMessage(Message message) throws WechatEcxeption {
		
		//1、先保存message主体
		message = saveMessageMain(message);
		//2、根据类型保存消息
		if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(message.getMessageType())){
			saveTextMessage(message);
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(message.getMessageType())){
			saveImageMessage(message);
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(message.getMessageType())){
			saveLinkMessage(message);
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(message.getMessageType())){
			saveLocationMessage(message);
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_VEDIO.equals(message.getMessageType())){
			saveVedioMessage(message);
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(message.getMessageType())){
			saveVoiceMessage(message);
		}
		if(MessageUtil.RESP_MESSAGE_TYPE_MUSIC.equals(message.getMessageType())){
			saveMusicMessage(message);
		}
		if(MessageUtil.RESP_MESSAGE_TYPE_NEWS.equals(message.getMessageType())){
			saveNewsMessage(message);
		}
	
		return true;
	}
	private void saveNewsMessage(Message message) throws WechatEcxeption {
		String sql = "insert into wechat_article_message(article_title,article_description,article_pic_url,article_url,message_id) values(?,?,?,?,?)";
		if(message instanceof ArticleMessage){
			final ArticleMessage am = (ArticleMessage)message;
			final List<Article> articles = am.getArticles();
			jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps, int i) throws SQLException {
					Article article = articles.get(i);
					ps.setString(1, article.getArticleTitle());
					ps.setString(2, article.getArticleDescription());
					ps.setString(3, article.getArticlePicUrl());
					ps.setString(4, article.getArticleUrl());
					ps.setInt(5, am.getMessageId());
				}
				@Override
				public int getBatchSize() {
					return articles.size();
				}
			});		
		}else{
			throw new WechatEcxeption("您保存的不是音乐格式的消息");
		}
	}
	private void saveMusicMessage(Message message) throws WechatEcxeption {
		String sql = "insert into wechat_music_message(music_title,music_description,music_url,hq_music_url,thumb_media_id,message_id) values(?,?,?,?,?,?)";
		if(message instanceof MusicMessage){
			MusicMessage mm = (MusicMessage)message;
			Music music = mm.getMusic();
			jdbcTemplate.update(sql,music.getMusicTitle(),music.getMusicDescription(),music.getMusicUrl(),music.gethQMusicUrl(),music.getThumbMediaId(),mm.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是音乐格式的消息");
		}
	}
	private void saveVoiceMessage(Message message) throws WechatEcxeption {
		String sql = "insert into wechat_voice_message(media_id,format,msg_id,recognition,message_id) values(?,?,?,?,?)";
		if(message instanceof VoiceMessage){
			VoiceMessage vm = (VoiceMessage)message;
			Voice vic = vm.getVoice();
			jdbcTemplate.update(sql,vic.getMediaId(),vic.getFormat(),vic.getMsgId(),vic.getRecognition(),vm.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是语音格式的消息");
		}
	}
	private void saveVedioMessage(Message message) throws WechatEcxeption {
		String sql = "insert into wechat_vedio_message(media_id,tilte,description,thumb_media_id,msg_id,message_id) values(?,?,?,?,?,?)";
		if(message instanceof VedioMessage){
			VedioMessage vm = (VedioMessage)message;
			Vedio vedio = vm.getVedio();
			jdbcTemplate.update(sql,vedio.getMediaId(),vedio.getTitle(),vedio.getDescription(),vedio.getThumbMediaId(),vedio.getMsgId(),vm.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是视频格式的消息");
		}
	}
	private void saveLocationMessage(Message message) throws WechatEcxeption {
		String sql = "insert into wechat_local_message(local_x,local_y,sacle,label,msg_id,message_id) values(?,?,?,?,?,?)";
		if(message instanceof LocalMessage){
			LocalMessage lm = (LocalMessage)message;
			jdbcTemplate.update(sql,lm.getLocalX(),lm.getLocalY(),lm.getScale(),lm.getLabel(),lm.getMsgId(),lm.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是地理位置格式的消息");
		}
	}
	private void saveLinkMessage(Message message) throws WechatEcxeption {
		String sql = "insert into wechat_href_message(href_title,href_description,href_url,msg_id,message_id) values(?,?,?,?,?)";
		if(message instanceof HrefMessage){
			HrefMessage hm = (HrefMessage)message;
			jdbcTemplate.update(sql,hm.getHrefTitle(),hm.getHrefDescription(),hm.getHrefUrl(),hm.getMsgId(),hm.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是链接格式的消息");
		}
		
	}
	private void saveImageMessage(Message message) throws WechatEcxeption {
		if(message instanceof ImageMessage){
			ImageMessage im = (ImageMessage)message;
			Image image = im.getImage();
			jdbcTemplate.update("insert into wechat_image_message(msg_id,media_id,pic_url,message_id) values(?,?,?,?)",image.getMsgId(),image.getMediaId(),image.getPicUrl(),im.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是图片格式的消息");
		}
		
	}
	private void saveTextMessage(Message message) throws WechatEcxeption{
		if(message instanceof TextMessage){
			TextMessage tm = (TextMessage)message;
			jdbcTemplate.update("insert into wechat_text_message(msg_id,content,message_id) values(?,?,?)",tm.getMsgId(),tm.getContent(),tm.getMessageId());
		}else{
			throw new WechatEcxeption("您保存的不是文本格式的消息");
		}
	}
	private Message saveMessageMain(final Message message) {
		final String msg_sql = "insert into wechat_message(message_from_user,message_to_user,message_type,message_create_time) values (?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
			    PreparedStatement ps = con.prepareStatement(msg_sql,PreparedStatement.RETURN_GENERATED_KEYS);
			    ps.setString(1,message.getMessageFromUser());
			    ps.setString(2,message.getMessageToUser());
			    ps.setString(3,message.getMessageType());
			    ps.setString(4,message.getMessageCreateTime());
			    return ps;
			}
		}, keyHolder);
		message.setMessageId(keyHolder.getKey().intValue());
		return message;
	}
	/*
	 * (non-Javadoc)
	 * @see com.wechat.message.dao.IMessageDao#loadMessageByMenu(java.lang.Integer)
	 */
	public Message loadMessageByMenuCode(String menuKeyCode) {
		String sql="select wm.message_id,wm.message_create_time,wm.message_type,wm.message_from_user,wm.message_to_user from wechat_message wm left join wechat_menu_message wmm ON wm.message_id = wmm.message_id where wmm.menu_key_code = ? ";

		Message msg = jdbcTemplate.queryForObject(sql, new Object[]{menuKeyCode},new RowMapper<Message>(){
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message m = new Message();
				m.setMessageType(rs.getString("message_type"));
				m.setMessageId(rs.getInt("message_id"));
				m.setMessageCreateTime(rs.getString("message_create_time"));
				m.setMessageFromUser(rs.getString("message_from_user"));
				m.setMessageToUser(rs.getString("message_to_user"));
				return m;
			}
			
		});
		if(msg==null) return null;
		//按照type来加载剩下的属性
		if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msg.getMessageType())){
			TextMessage tm = new TextMessage(msg);
			//加载文本消息
			loadTextMessage(tm);
			//返回
			return tm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msg.getMessageType())){
			HrefMessage hm = new HrefMessage(msg);
			//加载链接消息
			loadHrefMessage(hm);
			return hm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msg.getMessageType())){
			ImageMessage im = new ImageMessage(msg);
			//加载图片消息
			loadImageMessage(im);
			return im;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msg.getMessageType())){
			LocalMessage lm = new LocalMessage(msg);
			//加载地理位置消息
		    loadLocalMessage(lm);
		    return lm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_VEDIO.equals(msg.getMessageType())){
			VedioMessage vm = new VedioMessage(msg);
			//加载视频消息
			loadVedioMessage(vm);
			return vm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msg.getMessageType())){
			VoiceMessage vm = new VoiceMessage(msg);
			//加载语音消息
			loadVoiceMessage(vm);
			return vm;
		}
		if(MessageUtil.RESP_MESSAGE_TYPE_MUSIC.equals(msg.getMessageType())){
			MusicMessage mm = new MusicMessage(msg);
			//加载音乐消息
			loadMusicMessage(mm);
			return mm;
		}
		if(MessageUtil.RESP_MESSAGE_TYPE_NEWS.equals(msg.getMessageType())){
			ArticleMessage am = new ArticleMessage(msg);
			//加载图文消息
			return loadNewsMessage(am);
		}
		return null;
	}
	
	private ArticleMessage loadNewsMessage(ArticleMessage am) {
		String sql = "select article_id,article_title,article_description,article_pic_url,article_url from wechat_article_message where message_id = ?";
		List<Article> articles = jdbcTemplate.query(sql, new Object[]{am.getMessageId()}, new RowMapper<Article>(){
			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setArticleId(rs.getInt("article_id"));
				article.setArticleTitle(rs.getString("article_title"));
				article.setArticleDescription(rs.getString("article_description"));
				article.setArticlePicUrl(rs.getString("article_pic_url"));
				article.setArticleUrl(rs.getString("article_url"));
				return article;
			}
		});
		am.setArticleCount(articles.size());
		am.setArticles(articles);
		return am;
	}
	private void loadMusicMessage(final MusicMessage mm) {
		String sql = "select music_id,music_title,music_description,music_url,hq_music_url,thumb_media_id from wechat_music_message where message_id = ?";
		Music music = jdbcTemplate.queryForObject(sql, new Object[]{mm.getMessageId()}, new RowMapper<Music>(){
			@Override
			public Music mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Music m = new Music();
				m.setMusicId(rs.getInt("music_id"));
				m.setMusicTitle(rs.getString("music_title"));
				m.setMusicDescription(rs.getString("music_description"));
				m.setMusicUrl(rs.getString("music_url"));
				m.sethQMusicUrl(rs.getString("hq_music_url"));
				m.setThumbMediaId(rs.getString("thumb_media_id"));
				return m;
			}
			
		});
		mm.setMusic(music);
	}
	private void loadVoiceMessage(VoiceMessage vm) {
		String sql = "select voice_id,media_id,format,recognition,msg_id from wechat_voice_message where message_id = ?";
		Voice v = jdbcTemplate.queryForObject(sql, new Object[]{vm.getMessageId()}, new RowMapper<Voice>(){
			@Override
			public Voice mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Voice voice = new Voice();
				voice.setVoiceId(rs.getInt("voice_id"));
				voice.setFormat(rs.getString("format"));
				voice.setMediaId(rs.getString("media_id"));
				voice.setRecognition(rs.getString("recognition"));
				voice.setMsgId(rs.getString("msg_id"));
				return voice;
			}
			
		});
		vm.setVoice(v);
	}
	private void loadVedioMessage(VedioMessage vm) {
		String sql = "select vedio_id,media_id,tilte,description,thumb_media_id,msg_id from wechat_vedio_message where message_id = ?";
		Vedio vedio = jdbcTemplate.queryForObject(sql, new Object[]{vm.getMessageId()}, new RowMapper<Vedio>(){
			@Override
			public Vedio mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Vedio v = new Vedio();
				v.setVedioId(rs.getInt("vedio_id"));
				v.setTitle(rs.getString("tilte"));
				v.setMediaId(rs.getString("media_id"));
				v.setDescription(rs.getString("description"));
				v.setThumbMediaId(rs.getString("thumb_media_id"));
				v.setMsgId(rs.getString("msg_id"));
				
				return v;
			}
			
		});
		vm.setVedio(vedio);
		
	}
	private void loadLocalMessage(final LocalMessage lm) {
		String sql = "select local_message_id,local_x,local_y,scale,label,msg_id from wechat_local_message where message_id = ?";
		jdbcTemplate.queryForObject(sql, new Object[]{lm.getMessageId()}, new RowMapper<LocalMessage>(){
			@Override
			public LocalMessage mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				lm.setLocalMessageId(rs.getInt("local_message_id"));
				lm.setLocalX(rs.getString("local_x"));
				lm.setLocalY(rs.getString("local_y"));
				lm.setScale(rs.getString("scale"));
				lm.setLabel(rs.getString("label"));
				lm.setMsgId(rs.getString("msg_id"));
				return lm;
			}
			
		});
		
	}
	private void loadImageMessage(ImageMessage im) {
		String sql = "select image_id,media_id,pic_url,msg_id from wechat_image_message where message_id = ?";
		Image image = jdbcTemplate.queryForObject(sql, new Object[]{im.getMessageId()}, new RowMapper<Image>(){
			@Override
			public Image mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Image i = new Image();
				i.setImageId(rs.getInt("image_id"));
				i.setMediaId(rs.getString("media_id"));
				i.setPicUrl(rs.getString("pic_url"));
				i.setMsgId(rs.getString("msg_id"));
				
				return i;
			}
			
		});
		im.setImage(image);
	}
	private void loadHrefMessage(final HrefMessage hm) {
		String sql = "select href_id,href_title,href_description,href_url,msg_id from wechat_href_message where message_id = ?";
		jdbcTemplate.queryForObject(sql, new Object[]{hm.getMessageId()}, new RowMapper<HrefMessage>(){
			@Override
			public HrefMessage mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				hm.setHrefId(rs.getInt("href_id"));
				hm.setHrefTitle(rs.getString("href_title"));
				hm.setHrefDescription(rs.getString("href_description"));
				hm.setHrefUrl(rs.getString("href_url"));
				hm.setMsgId(rs.getString("msg_id"));
				return hm;
			}
			
		});
	}
	private void loadTextMessage(final TextMessage tm) {
		String sql = "select text_message_id,msg_id,content from wechat_text_message where message_id = ?";
		jdbcTemplate.queryForObject(sql, new Object[]{tm.getMessageId()},new RowMapper<TextMessage>(){
			public TextMessage mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				tm.setTextMessageId(rs.getInt("text_message_id"));
				tm.setMsgId(rs.getString("msg_id"));
				tm.setContent(rs.getString("content"));
				return tm;
			}
		});
	}
	
	@Override
	public Message loadMessageByEventCode(String eventCode) {

		String sql="select wm.message_id,wm.message_create_time,wm.message_type,wm.message_from_user,wm.message_to_user "
				+ "from wechat_message wm "
				+ "left join wechat_event_message wem ON wm.message_id = wem.message_id "
				+ "where wem.event_code = ? ";

		Message msg = jdbcTemplate.queryForObject(sql, new Object[]{eventCode},new RowMapper<Message>(){
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message m = new Message();
				m.setMessageType(rs.getString("message_type"));
				m.setMessageId(rs.getInt("message_id"));
				m.setMessageCreateTime(rs.getString("message_create_time"));
				m.setMessageFromUser(rs.getString("message_from_user"));
				m.setMessageToUser(rs.getString("message_to_user"));
				return m;
			}
			
		});
		if(msg==null) return null;
		//按照type来加载剩下的属性
		if(MessageUtil.REQ_MESSAGE_TYPE_TEXT.equals(msg.getMessageType())){
			TextMessage tm = new TextMessage(msg);
			//加载文本消息
			loadTextMessage(tm);
			//返回
			return tm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_LINK.equals(msg.getMessageType())){
			HrefMessage hm = new HrefMessage(msg);
			//加载链接消息
			loadHrefMessage(hm);
			return hm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_IMAGE.equals(msg.getMessageType())){
			ImageMessage im = new ImageMessage(msg);
			//加载图片消息
			loadImageMessage(im);
			return im;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_LOCATION.equals(msg.getMessageType())){
			LocalMessage lm = new LocalMessage(msg);
			//加载地理位置消息
		    loadLocalMessage(lm);
		    return lm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_VEDIO.equals(msg.getMessageType())){
			VedioMessage vm = new VedioMessage(msg);
			//加载视频消息
			loadVedioMessage(vm);
			return vm;
		}
		if(MessageUtil.REQ_MESSAGE_TYPE_VOICE.equals(msg.getMessageType())){
			VoiceMessage vm = new VoiceMessage(msg);
			//加载语音消息
			loadVoiceMessage(vm);
			return vm;
		}
		if(MessageUtil.RESP_MESSAGE_TYPE_MUSIC.equals(msg.getMessageType())){
			MusicMessage mm = new MusicMessage(msg);
			//加载音乐消息
			loadMusicMessage(mm);
			return mm;
		}
		if(MessageUtil.RESP_MESSAGE_TYPE_NEWS.equals(msg.getMessageType())){
			ArticleMessage am = new ArticleMessage(msg);
			//加载图文消息
			return loadNewsMessage(am);
		}
		return null;
	}

}
