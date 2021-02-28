articles = ['createAccountArticle','depositArticle','withdrawArticle',
			'selectAccountByIdArticle', 'selectAllAccountsArticle','loginArticle'];
$.article_select = function(article) {
	$.each(articles, function(index, el) {
		$('#'+el).css('display','none');
	});
	$('#'+article).css('display','block');
}

$(function() {
	$.article_select(articles[0]);
	$('.btn').click(function() {
		$.article_select(articles[Number($(this).attr('id'))]);
	});
	$('input[type=radio]').change(function(){
		if ($(this).val()=='normal') {
			$('select').attr('disabled','disabled');
		} else {
			$('select').removeAttr('disabled');
		}
	});
	$('#createAccount').submit(function(event) {
		if ($('#accNo').val()=='') {
			alert('계좌번호를 입력하세요.');
			event.preventDefault();
			return;
		}
		if ($('#name').val()=='') {
			alert('이름을 입력하세요.');
			event.preventDefault();
			$('#name').focus();
			return;
		}
		if ($('#balance').val()=='') {
			alert('입금액을 입력하세요.');
			event.preventDefault();
			$('#balance').focus();
			return;
		}
	});
	$('#deposit').submit(function(event) {
		if ($('#accNo').val()=='') {
			alert('계좌번호를 입력하세요.');
			event.preventDefault();
			return;
		}
		if ($('#money').val()=='') {
			alert('입금액을 입력하세요.');
			event.preventDefault();
			$('#money').focus();
			return;
		}
	});
	$('#withdraw').submit(function(event) {
		if ($('#accNo').val()=='') {
			alert('계좌번호를 입력하세요.');
			event.preventDefault();
			return;
		}
		if ($('#money').val()=='') {
			alert('출금액을 입력하세요.');
			event.preventDefault();
			$('#money').focus();
			return;
		}
	});
	$('#selectAccountById').submit(function(event) {
		if ($('#accNo').val()=='') {
			alert('계좌번호를 입력하세요.');
			event.preventDefault();
			return;
		}
	});
	$('#login').submit(function(event) {
		if ($('#id').val()=='') {
			alert('이름을 입력하세요.');
			event.preventDefault();
			$('#id').focus();
			return;
		}
		if ($('#password').val()=='') {
			alert('비밀번호를 입력하세요.');
			$('#password').focus();
			event.preventDefault();
			return;
		}
	});
});
