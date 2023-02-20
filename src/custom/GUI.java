package custom;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URI;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import burp.BurpExtender;
import burp.IHttpRequestResponse;
import burp.IMessageEditor;
import recon.myGSA;
import recon.myjsdati;


public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private String github = "https://github.com/mehta-zenith";
	private String helpurl = github;


	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JSplitPane splitPane;
	private JSplitPane splitPane_1;
	private JSplitPane splitPane_2;
	public JTextArea imgRequestRaws;
	public JTextArea APIRequestRaws;
	private JPanel panel;
	private JPanel panel_1;
	public JButton btnRequest;
	private JButton btnRequestAPI;
	private JLabel label_showimg;
	public JTextField imgHttpService;

	public IMessageEditor imageMessageEditor;
	public static JRadioButton rdbtnUseSelfApi;
	public static JRadioButton rdbtnUseProxy;
	public static JTextField proxyUrl = new JTextField();

	private JPanel panel_IMessage;
	private JPanel panel_4;
	private JTextArea APIResulttextArea;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JTextField imgPath;
	private JLabel lblAboutTypeid;
	private JComboBox<String> APIcomboBox;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 497);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		splitPane = new JSplitPane();
		splitPane.setResizeWeight(0.5);
		splitPane.setDividerLocation(0.5);
		contentPane.add(splitPane, BorderLayout.CENTER);

		splitPane_1 = new JSplitPane();
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_1.setResizeWeight(0.6);
		splitPane.setLeftComponent(splitPane_1);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane_1.setRightComponent(panel);
		panel.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.NORTH);

		rdbtnUseSelfApi = new JRadioButton("Use Self Api with proxy");
		rdbtnUseSelfApi.setSelected(false);
		panel_6.add(rdbtnUseSelfApi);

		panel_6.add(proxyUrl);
		proxyUrl.setText("http://127.0.0.1:8080");
		proxyUrl.setEnabled(false);

		rdbtnUseSelfApi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnUseSelfApi.isSelected()) {
					proxyUrl.setEnabled(true);
				}else {
					proxyUrl.setEnabled(false);
				}
			}
		});


		btnRequest = new JButton("Get Image");
		panel_6.add(btnRequest);
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetImageThread thread = new GetImageThread(BurpExtender.getImgMessageInfo());
				thread.start();
		
			}
		});

		panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.CENTER);

		label_showimg = new JLabel("");
		panel_7.add(label_showimg);
		label_showimg.setHorizontalAlignment(SwingConstants.RIGHT);

		imgPath = new JTextField();
		panel_7.add(imgPath);
		imgPath.setColumns(30);


		panel_IMessage = new JPanel();
		panel_IMessage.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane_1.setLeftComponent(panel_IMessage);
		panel_IMessage.setLayout(new BorderLayout(0, 0));

		imgHttpService = new JTextField();
		panel_IMessage.add(imgHttpService, BorderLayout.NORTH);
		imgHttpService.setHorizontalAlignment(SwingConstants.LEFT);
		imgHttpService.setColumns(30);

		imgRequestRaws = new JTextArea();
		panel_IMessage.add(imgRequestRaws, BorderLayout.CENTER);
		imgRequestRaws.setLineWrap(true);


		splitPane_2 = new JSplitPane();
		splitPane_2.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane_2.setResizeWeight(0.6);
		splitPane.setRightComponent(splitPane_2);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane_2.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		APIResulttextArea = new JTextArea();
		APIResulttextArea.setWrapStyleWord(true);
		APIResulttextArea.setFont(new Font( Font.BOLD, 12));
		panel_1.add(APIResulttextArea);

		panel_5 = new JPanel();
		panel_1.add(panel_5, BorderLayout.NORTH);

		rdbtnUseProxy = new JRadioButton("Use Proxy");
		rdbtnUseProxy.setSelected(false);
		panel_5.add(rdbtnUseProxy);

		btnRequestAPI = new JButton("Get Answer");
		btnRequestAPI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		
				btnRequestAPI.setEnabled(false);
				GetAnswerThread thread = new GetAnswerThread(imgPath.getText());
				thread.start();
			}
		});
		panel_5.add(btnRequestAPI);
		btnRequestAPI.setHorizontalAlignment(SwingConstants.LEFT);

		lblAboutTypeid = new JLabel("Help?");
		lblAboutTypeid.setHorizontalAlignment(SwingConstants.LEFT);
		lblAboutTypeid.setFont(new Font("ו", Font.BOLD, 12));
		lblAboutTypeid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI(helpurl);
					Desktop desktop = Desktop.getDesktop();
					if(Desktop.isDesktopSupported()&&desktop.isSupported(Desktop.Action.BROWSE)){
						desktop.browse(uri);
					}
				} catch (Exception e2) {
					//callbacks.printError(e2.getMessage());
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAboutTypeid.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAboutTypeid.setForeground(Color.BLACK);
			}
		});
		panel_5.add(lblAboutTypeid);


		panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		splitPane_2.setLeftComponent(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		APIRequestRaws = new JTextArea();
		panel_4.add(APIRequestRaws);
		APIRequestRaws.setLineWrap(true);

		APIcomboBox = new JComboBox<String>();
		APIcomboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (APIcomboBox.getSelectedItem().equals("GSA Captcha Breaker"))
				{
					APIRequestRaws.setText("http://127.0.0.1");
					helpurl="https://www.gsa-online.de/gsa-docu/";
				}
				if (APIcomboBox.getSelectedItem().equals("https://www.jsdati.com"))
				{
					APIRequestRaws.setText("username=bit4woo&password=password&captchaType=1001");
					helpurl = "https://www.jsdati.com/docs/price";
				}
			}
		});
		panel_4.add(APIcomboBox, BorderLayout.NORTH);
		APIcomboBox.addItem("https://www.jsdati.com");
		APIcomboBox.addItem("GSA Captcha Breaker");

		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel_2, BorderLayout.SOUTH);

		lblNewLabel_2 = new JLabel("    "+github);
		lblNewLabel_2.setFont(new Font( Font.BOLD, 12));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					URI uri = new URI(github);
					Desktop desktop = Desktop.getDesktop();
					if(Desktop.isDesktopSupported()&&desktop.isSupported(Desktop.Action.BROWSE)){
						desktop.browse(uri);
					}
				} catch (Exception e2) {
					//callbacks.printError(e2.getMessage());
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.BLUE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setForeground(Color.BLACK);
			}
		});
		panel_2.add(lblNewLabel_2);
	}


	public String getAnswer(String imgpath) {
		Object Method = this.APIcomboBox.getSelectedItem();
		String result = "";
		String proxyUrl = "";
		if (GUI.rdbtnUseProxy.isSelected()) {
			proxyUrl = GUI.proxyUrl.getText().trim();
		}
		if(!imgpath.equals("")) {
			if (Method.equals("GSA Captcha Breaker"))
			{	
				String httpService = APIRequestRaws.getText();
				result = myGSA.getCode(imgpath, httpService,proxyUrl);
			}else if (Method.equals("https://www.jsdati.com")) 
			{
				String para = APIRequestRaws.getText();
				try {
					result = myjsdati.getCode(imgpath, para,proxyUrl);
				} catch (Exception e) {
					e.printStackTrace(BurpExtender.stderr);
				}
			}
		} else {
			result = "image path is null!";
		}
		return result;
	}

	public class GetAnswerThread extends Thread {
		private String imgpath;

		public GetAnswerThread(String imgpath) {
			this.imgpath = imgpath;
		}
		public void run() {
			String imgpath = imgPath.getText();
			String result = getAnswer(imgpath);
			APIResulttextArea.setText(result);
			btnRequestAPI.setEnabled(true);
		}
	}

	public class GetImageThread extends Thread {
		private IHttpRequestResponse MessageInfo;

		public GetImageThread(IHttpRequestResponse MessageInfo) {
			this.MessageInfo = MessageInfo;
		}
		public void run() {
			try {
		
				btnRequest.setEnabled(false);
				String imageName = BurpExtender.getImage(MessageInfo);
				imgPath.setText(imageName);

				//label_showimg.setIcon(new ImageIcon(imgpath));
				Image image = ImageIO.read(new File(imageName));
				ImageIcon icon = new ImageIcon(image);
				label_showimg.setIcon(icon);
			} catch (Exception e) {
				e.printStackTrace(BurpExtender.stderr);
				imgPath.setText(e.getMessage());
			} finally {
				btnRequest.setEnabled(true);
			}
		}
	}
}